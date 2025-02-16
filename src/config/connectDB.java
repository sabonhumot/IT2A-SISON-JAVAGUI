/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Administrator
 */
public class connectDB {

    private Connection connect;
    private static final String DB_URL = "jdbc:mysql://localhost:3306/careq";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    public connectDB() {
        try {
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/careq", "root", "");
        } catch (SQLException ex) {
            System.out.println("Can't connect to database: " + ex.getMessage());
        }
    }

    //Function to save data
    public int insertData(String sql) {
        int result;
        try {
            PreparedStatement pst = connect.prepareStatement(sql);
            pst.executeUpdate();
            System.out.println("Inserted Successfully!");
            pst.close();
            result = 1;
        } catch (SQLException ex) {
            System.out.println("Connection Error: " + ex);
            result = 0;
        }
        return result;
    }

    //Function to retrieve data
    public ResultSet getData(String sql) throws SQLException {
        Statement stmt = connect.createStatement();
        ResultSet rst = stmt.executeQuery(sql);
        return rst;
    }

    public static Connection getConnection() throws SQLException {
        try {
            return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (SQLException ex) {
            System.err.println("Database Connection Error: " + ex.getMessage()); // Or use a logger
            throw ex; // Re-throw the exception to be handled by the calling code
        }
    }

}
