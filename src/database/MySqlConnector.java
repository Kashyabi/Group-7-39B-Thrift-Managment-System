
package database;

import database.db;
import java.sql.*;

/**
 *
 * @author Lenovo
 */


public class MySqlConnector implements db {
 
    public Connection openConnection(){
    try{
        String username= "root";
        String password="1234";
        String database= "apex";
        Connection connection;
        connection =DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/" + database,username,password
        
        ); 
        if (connection==null){
            System.out.println("Connection null");
        }else{
            System.out.println("Connection success");
        }
        return connection;
    }catch(Exception e){
        System.out.println(e);
    }
    return null;
}
}