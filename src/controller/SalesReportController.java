package controller;

import model.SalesReport;
import Database.MySqlConnector;
import java.sql.*;

public class SalesReportController {

    private MySqlConnector db = new MySqlConnector();

    public SalesReport getSalesReport() {
        SalesReport report = new SalesReport();
        Connection conn = db.openConnection();
        
        if (conn == null) {
            System.out.println("❌ Could not connect to database");
            return report;
        }
        
        try {
            // 1. Total Sales (sum of delivered orders)
            ResultSet rs1 = db.runQuery(conn, 
                "SELECT COALESCE(SUM(total_amount), 0) AS total FROM orders WHERE status = 'Delivered'");
            if (rs1 != null && rs1.next()) {
                report.setTotalSales(rs1.getDouble("total"));
            }
            
            // 2. Total Orders
            ResultSet rs2 = db.runQuery(conn, "SELECT COUNT(*) AS total FROM orders");
            if (rs2 != null && rs2.next()) {
                report.setTotalOrders(rs2.getInt("total"));
            }
            
            // 3. Average Order Value
            ResultSet rs3 = db.runQuery(conn, 
                "SELECT COALESCE(AVG(total_amount), 0) AS avg FROM orders");
            if (rs3 != null && rs3.next()) {
                report.setAverageOrderValue(rs3.getDouble("avg"));
            }
            
            // 4. Pending Orders
            ResultSet rs4 = db.runQuery(conn, 
                "SELECT COUNT(*) AS total FROM orders WHERE status = 'Pending'");
            if (rs4 != null && rs4.next()) {
                report.setPendingOrders(rs4.getInt("total"));
            }
            
            // 5. Delivered Orders
            ResultSet rs5 = db.runQuery(conn, 
                "SELECT COUNT(*) AS total FROM orders WHERE status = 'Delivered'");
            if (rs5 != null && rs5.next()) {
                report.setDeliveredOrders(rs5.getInt("total"));
            }
            
            // 6. Cancelled Orders
            ResultSet rs6 = db.runQuery(conn, 
                "SELECT COUNT(*) AS total FROM orders WHERE status = 'Cancelled'");
            if (rs6 != null && rs6.next()) {
                report.setCancelledOrders(rs6.getInt("total"));
            }
            
            // 7. Top Selling Product
            ResultSet rs7 = db.runQuery(conn,
                "SELECT p.name, COUNT(o.id) AS order_count " +
                "FROM orders o JOIN products p ON o.product_id = p.id " +
                "GROUP BY p.id, p.name ORDER BY order_count DESC LIMIT 1");
            if (rs7 != null && rs7.next()) {
                report.setTopSellingProduct(rs7.getString("name"));
            } else {
                report.setTopSellingProduct("N/A");
            }
            
            // 8. Total Users (buyers)
            ResultSet rs8 = db.runQuery(conn, 
                "SELECT COUNT(*) AS total FROM users WHERE role = 'buyer'");
            if (rs8 != null && rs8.next()) {
                report.setTotalUsers(rs8.getInt("total"));
            }
            
        } catch (SQLException e) {
            System.out.println("❌ Error loading sales report: " + e.getMessage());
        } finally {
            db.closeConnection(conn);
        }
        
        return report;
    }
}