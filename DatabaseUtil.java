/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.util;
import java.sql.*;
/**
 *
 * @author mypc
 */
public class DatabaseUtil {

    public static final String DRIVER_PATH = "com.mysql.cj.jdbc.Driver";
    public static final String DATABASE_URL = "jdbc:mysql://localhost:3306/test";
    public static final String USER = "root";
    public static final String PASS = "";

    public DatabaseUtil() {
        try {
            Class.forName(DRIVER_PATH);
        } catch (Exception e) {
            throw new RuntimeException("something went wrong" + e);

        }
    }//end of constructor

    /**
     *
     * @return
     * @throws SQLException
     */
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DATABASE_URL, USER, PASS);
    }
}
