/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group11.cp2;

import java.util.List;
import java.time.LocalDate;
import java.time.LocalTime;
/**
 *
 * @author Pil,Kristopher,Janice,Clarinda
 */
public class MotorPHApp {
    public static void main(String[] args) {
        // Step 1: Read employees from CSV
        List<Employee> employees = EmployeeCSVReader.readEmployeesFromCSV("src/main/resources/MotorPH Employee Data - Employee Details.csv");
        // Create Employee
        Employee emp = new Employee(10001, "Garcia", "Manuel III", 
            LocalDate.of(1983, 10, 11), "Chief Executive Officer", 90000.0, 
            1500.0, 2000.0, 1000.0, 45000.0, 535.71);

        // Create User
        User user = new User("manuel_g", "pass123", "Employee", emp);

        // Simulate login
        boolean loginSuccess = user.login("manuel_g", "pass123");
        System.out.println("Login success: " + loginSuccess); // Should print true

        // Simulate attendance
        AttendanceRecord attendance = new AttendanceRecord(LocalDate.now(),
                LocalTime.of(8, 0), LocalTime.of(17, 0));
        double hoursWorked = attendance.computeWorkHours();
        System.out.println("Hours worked: " + hoursWorked);

        // Calculate deductions
        Deductions deductions = new Deductions();
        deductions.setDeductions(emp.getGrossSemiMonthlyRate());

        // Compute payroll
        Payroll payroll = new Payroll(emp, hoursWorked, deductions); // Pass Employee object
        payroll.computeGrossPay(); // No need to pass hourlyRate anymore
        payroll.computeNetPay();

        System.out.println("Employee Name: " + payroll.getEmployeeName());
        System.out.println("Gross Pay: " + payroll.getGrossPay());
        System.out.println("Total Deductions: " + deductions.getTotal());
        System.out.println("Net Pay: " + payroll.getNetPay());
        
    }
    
}
