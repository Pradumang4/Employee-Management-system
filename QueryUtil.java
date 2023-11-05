/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jdbc.util;

/**
 *
 * @author mypc
 */
public class QueryUtil {

    public static String insertEmployeeQuery() {
        return "INSERT INTO dbms (NAME,ADDRESS,SALARY) VALUES (?,?,?)";
    }

    public static String selectAllEmployeeQuery() {
        return "SELECT * FROM dbms";
    }

    public static String selectEmployeeById(int employeeId) {
        return "SELECT * FROM dbms WHERE ID = " + employeeId;
    }

    public static String deleteEmployeeById(int employeeId) {
        return "DELETE FROM dbms WHERE ID = " + employeeId;
    }
     public static String updateEmployeeById(int employeeId) {
        return "UPDATE dbms SET NAME = ?,ADDRESS = ?,SALARY = ? WHERE ID = "+employeeId;
    }
}
