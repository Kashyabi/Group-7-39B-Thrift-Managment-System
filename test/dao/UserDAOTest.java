/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package dao;

import model.logindata;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author saruk
 */
public class UserDAOTest {
    
    public UserDAOTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of createUser method, of class UserDAO.
     */
    @Test
    public void testCreateUser() {
        System.out.println("createUser");
        logindata user = null;
        UserDAO instance = new UserDAO();
        boolean expResult = false;
        boolean result = instance.createUser(user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkUser method, of class UserDAO.
     */
    @Test
    public void testCheckUser() {
        System.out.println("checkUser");
        logindata user = null;
        UserDAO instance = new UserDAO();
        boolean expResult = false;
        boolean result = instance.checkUser(user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updatePassword method, of class UserDAO.
     */
    @Test
    public void testUpdatePassword() {
        System.out.println("updatePassword");
        String email = "";
        String newPassword = "";
        UserDAO instance = new UserDAO();
        boolean expResult = false;
        boolean result = instance.updatePassword(email, newPassword);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserRole method, of class UserDAO.
     */
    @Test
    public void testGetUserRole() {
        System.out.println("getUserRole");
        String email = "";
        UserDAO instance = new UserDAO();
        String expResult = "";
        String result = instance.getUserRole(email);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserIdByEmail method, of class UserDAO.
     */
    @Test
    public void testGetUserIdByEmail() {
        System.out.println("getUserIdByEmail");
        String email = "";
        UserDAO instance = new UserDAO();
        int expResult = 0;
        int result = instance.getUserIdByEmail(email);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addBuyerDetails method, of class UserDAO.
     */
    @Test
    public void testAddBuyerDetails() {
        System.out.println("addBuyerDetails");
        int userId = 0;
        UserDAO instance = new UserDAO();
        boolean expResult = false;
        boolean result = instance.addBuyerDetails(userId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addSellerDetails method, of class UserDAO.
     */
    @Test
    public void testAddSellerDetails() {
        System.out.println("addSellerDetails");
        int userId = 0;
        UserDAO instance = new UserDAO();
        boolean expResult = false;
        boolean result = instance.addSellerDetails(userId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
