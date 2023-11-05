package com.jdbc.main;

import com.jdbc.model.Employee;
import com.jdbc.servies.DatabaseService;
import java.util.*;

public class MainClass {

   public static void main(String[] args) {

      DatabaseService databaseService = new DatabaseService();
      try (Scanner in = new Scanner(System.in);) {

         boolean isRunning = true;
         while (isRunning) {

            System.out.println("**************WELCOME TO EMPLOYEE MANAGEMENT SYSTEM**************");
            System.out.println("ENTER YOUR CHOICE TO  : ");
            System.out.println("1.INSERT EMPLOYEE ");
            System.out.println("2.SELECT ALL EMPLOYEE ");
            System.out.println("3.SELECT EMPLOYEE BY USING EMPLOYEE  ID ");
            System.out.println("4.DELETE EMPLOYEE ");
            System.out.println("5.UPDATE EMPLOYEE ");
            System.out.println("6.EXIT ");

            int choice = Integer.parseInt(in.nextLine());
            switch (choice) {
               case 1:
                  System.out.println("Enter name,Address,Salary");
                  databaseService.insertEmployee(new Employee(in.nextLine(), in.nextLine(), (float) Double.parseDouble(in.nextLine())));
                  break;
               case 2:
                  databaseService.getAllEmployees();
                  break;
               case 3:
                  System.out.println("Enter ID of an Employee");
                  databaseService.getEmployeeById(Integer.parseInt(in.nextLine()));
                  break;
               case 4:
                  System.out.println("Enter ID of an Employee");
                  databaseService.deleteEmployeeById(Integer.parseInt(in.nextLine()));
                  break;
               case 5:
                  System.out.println("Enter ID of an Employee to Update");
                  int updateId = Integer.parseInt(in.nextLine());
                  boolean isfound = databaseService.getEmployeeById(updateId);
                  if (isfound) {
                     System.out.println("Enter name,Address,Salary");
                     Employee employee = new Employee(updateId, in.nextLine(), in.nextLine(), Double.parseDouble(in.nextLine()));
                     databaseService.updateEmployee(employee);
                  }
                  break;
               case 6:
                  System.out.println("thank you and visit again");
                  isRunning = false;
                  break;
               default:
                  System.out.println("Wrong choice");
                  break;
            }

         }
      } catch (Exception e) {
         throw new RuntimeException("Something went wrong" + e);
      }

   }
}
