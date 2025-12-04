package com.company.swissre.service;

import com.company.swissre.model.Employee;
import java.util.*;

public class EmployeeAnalyzer {

    private Map<Integer, Employee> map = new HashMap<>();
    private Map<Integer, List<Employee>> children = new HashMap<>();

    public EmployeeAnalyzer(List<Employee> employees) {
        for (Employee e : employees) {
            map.put(e.getId(), e);
            children.putIfAbsent(e.getId(), new ArrayList<>());

            if (e.getManagerId() != null) {
                children.putIfAbsent(e.getManagerId(), new ArrayList<>());
                children.get(e.getManagerId()).add(e);
            }
        }
    }

    // ------ Salary Rule 20% - 50% -----
    public void checkManagerSalaryRules() {
        System.out.println("Managers earning LESS than allowed:");

        for (Employee manager : map.values()) {
            List<Employee> subs = children.get(manager.getId());
            if (subs == null || subs.isEmpty()) continue;

            double avg = subs.stream().mapToDouble(Employee::getSalary).average().orElse(0);
            double minAllowed = avg * 1.20;

            if (manager.getSalary() < minAllowed) {
                System.out.println("Manager " + manager.getName()
                        + " should earn at least " + minAllowed
                        + " but earns " + manager.getSalary()
                        + " (short by " + (minAllowed - manager.getSalary()) + ")");
            }
        }

        System.out.println("\nManagers earning MORE than allowed:");

        for (Employee manager : map.values()) {
            List<Employee> subs = children.get(manager.getId());
            if (subs == null || subs.isEmpty()) continue;

            double avg = subs.stream().mapToDouble(Employee::getSalary).average().orElse(0);
            double maxAllowed = avg * 1.50;

            if (manager.getSalary() > maxAllowed) {
                System.out.println("Manager " + manager.getName()
                        + " should earn no more than " + maxAllowed
                        + " but earns " + manager.getSalary()
                        + " (excess by " + (manager.getSalary() - maxAllowed) + ")");
            }
        }
    }

    // ------------ Reporting Line Depth ------------
    public void checkReportingDepth() {
    System.out.println("\nEmployees with TOO LONG reporting lines:");

    int MAX_DEPTH = 4;  

    for (Employee e : map.values()) {
        int depth = 1;  
        Integer managerId = e.getManagerId();

        while (managerId != null) {
            Employee manager = map.get(managerId);
            if (manager == null) break;  

            depth++;
            managerId = manager.getManagerId();
        }

        if (depth > MAX_DEPTH) {
            System.out.println("Employee " + e.getName() +
                    " has a reporting depth of " + depth +
                    " levels (too long by " + (depth - MAX_DEPTH) + ")");
        }
    }
}

}
