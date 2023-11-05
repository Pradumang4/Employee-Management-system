/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jdbc.model;

/**
 *
 * @author mypc
 */
public class Employee {
    private  int employeeID;
    private  String employeeNAME;
    private  String employeeADDRESS;
    private  double employeeSALARY;

    public Employee(int employeeID, String employeeNAME, String employeeADDRESS, double employeeSALARY) {
        this.employeeID = employeeID;
        this.employeeNAME = employeeNAME;
        this.employeeADDRESS = employeeADDRESS;
        this.employeeSALARY = employeeSALARY;
    }
    

    public Employee(String employeeNAME, String employeeADDRESS, double employeeSALARY) {
        this.employeeNAME = employeeNAME;
        this.employeeADDRESS = employeeADDRESS;
        this.employeeSALARY = employeeSALARY;
    }
    
    
    
    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeNAME() {
        return employeeNAME;
    }

    public void setEmployeeNAME(String employeeNAME) {
        this.employeeNAME = employeeNAME;
    }

    public String getEmployeeADDRESS() {
        return employeeADDRESS;
    }

    public void setEmployeeADDRESS(String employeeADDRESS) {
        this.employeeADDRESS = employeeADDRESS;
    }

    public double getEmployeeSALARY() {
        return employeeSALARY;
    }

    public void setEmployeeSALARY(float employeeSALARY) {
        this.employeeSALARY = employeeSALARY;
    }
    
    
   }
