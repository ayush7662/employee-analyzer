package com.company.swissre;

import com.company.swissre.model.Employee;
import com.company.swissre.service.EmployeeAnalyzer;
import com.company.swissre.util.CsvReader;

import java.util.List;

public class App {
    public static void main(String[] args) {
        try {
            ClassLoader loader = App.class.getClassLoader();
            String filePath = loader.getResource("employees.csv").getPath();

            List<Employee> employees = CsvReader.readEmployees(filePath);

            EmployeeAnalyzer analyzer = new EmployeeAnalyzer(employees);

            analyzer.checkManagerSalaryRules();
            analyzer.checkReportingDepth();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
