/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group11.cp2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author ADMIN
 */
public class EmployeeCSVReader {
    public static List<Employee> readEmployeesFromCSV(String filePath) {
        List<Employee> employees = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            // Skip header
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                Employee emp = new Employee(
                    Integer.parseInt(data[0]), // ID
                    data[1],                   // Last Name
                    data[2],                   // First Name
                    LocalDate.parse(data[3]),  // Birth Date
                    data[4],                   // Position
                    Double.parseDouble(data[5]), // Rate Per Day
                    Double.parseDouble(data[6]), // SSS
                    Double.parseDouble(data[7]), // PagIbig
                    Double.parseDouble(data[8]), // PhilHealth
                    Double.parseDouble(data[9]), // Withholding Tax
                    Double.parseDouble(data[10]) // Other Deductions
                );

                employees.add(emp);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return employees;
    }
}
