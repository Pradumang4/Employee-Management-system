/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jdbc.servies;

import com.java.util.DatabaseUtil;
import com.jdbc.model.Employee;
import com.jdbc.util.QueryUtil;
import java.sql.*;
import java.util.*;
import javax.crypto.AEADBadTagException;

/**
 *
 * @author mypc
 */
public class DatabaseService {

   DatabaseUtil databaseUtil = new DatabaseUtil();

   public void insertEmployee(Employee employee) throws SQLException {
      try (Connection connection = databaseUtil.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(QueryUtil.insertEmployeeQuery());) {
         preparedStatement.setString(1, employee.getEmployeeNAME());
         preparedStatement.setString(2, employee.getEmployeeADDRESS());
         preparedStatement.setDouble(3, employee.getEmployeeSALARY());
         int rows = preparedStatement.executeUpdate();
         if (rows > 0) {
            System.out.println("Record created successfully");
         } else {
            System.out.println("Insert record failed");
         }
      } catch (Exception e) {
         throw new RuntimeException("Something went wrong" + e);
      }
   }//end of insertEmployee

   public void getAllEmployees() throws SQLException {
      try (Connection connection = databaseUtil.getConnection(); Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(QueryUtil.selectAllEmployeeQuery())) {
         while (resultSet.next()) {
            printEmployee(new Employee(resultSet.getInt("ID"),
                    resultSet.getString("NAME"),
                    resultSet.getString("ADDRESS"),
                    resultSet.getDouble("SALARY")));
         }
      }
   }//end of get all employee

   private void printEmployee(Employee employee) {
      System.out.println("Employee ID: " + employee.getEmployeeID());
      System.out.println("Employee NAME: " + employee.getEmployeeNAME());
      System.out.println("Employee ADDRESS: " + employee.getEmployeeADDRESS());
      System.out.println("Employee SALARY: " + employee.getEmployeeSALARY());
      System.out.println("---------------------------------");
   }

   public boolean getEmployeeById(int id) throws SQLException {
      boolean isfound = false;
      try (Connection connection = databaseUtil.getConnection(); Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(QueryUtil.selectEmployeeById(id));) {
         if (resultSet.next()) {
            isfound = true;
            printEmployee(new Employee(resultSet.getInt("ID"),
                    resultSet.getString("NAME"),
                    resultSet.getString("ADDRESS"),
                    resultSet.getDouble("SALARY")));

         } else {
            System.out.println("Record not found for id " + id);
         }

      }

      return isfound;
   }//End of getEmployeeById

   public void deleteEmployeeById(int EmployeeId) throws SQLException {
      try (Connection connection = databaseUtil.getConnection(); Statement statement = connection.createStatement();) {
         int rows = statement.executeUpdate(QueryUtil.deleteEmployeeById(EmployeeId));
         if (rows > 0) {
            System.out.println("Record deleted successfullty");
         } else {
            System.out.println("Something went Wrong");
         }

      }

   }//end od delete Employee bye id

   public void updateEmployee(Employee employee) throws SQLException {
      try (Connection connection = databaseUtil.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(QueryUtil.updateEmployeeById(employee.getEmployeeID()));) {
              preparedStatement.setString(1,employee.getEmployeeNAME());
              preparedStatement.setString(2,employee.getEmployeeADDRESS());
              preparedStatement.setDouble(3,employee.getEmployeeSALARY());
              
              int rows=preparedStatement.executeUpdate();
              if(rows>0){
                 System.out.println("Record Updated sucessfully");
              }
      }

   }//End of UPDATE employee by id

}
