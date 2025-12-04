package com.company.swissre.util;

import com.company.swissre.model.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {

    public static List<Employee> readEmployees(String filePath) {
        List<Employee> employees = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;
            br.readLine(); 

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");

                int id = Integer.parseInt(parts[0].trim());
                String name = parts[1].trim();
                double salary = Double.parseDouble(parts[2].trim());

                // FIXED MANAGER ID PARSING
                Integer managerId = null;
                if (parts.length > 3 && !parts[3].trim().isEmpty()) {
                    managerId = Integer.parseInt(parts[3].trim());
                }

                employees.add(new Employee(id, name, salary, managerId));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return employees;
    }
}
