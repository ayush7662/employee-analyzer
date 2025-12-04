package com.company.swissre.model;

public class Employee {
    private int id;
    private String name;
    private double salary;
    private Integer managerId;

    public Employee(int id, String name, double salary, Integer managerId) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.managerId = managerId;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getSalary() { return salary; }
    public Integer getManagerId() { return managerId; }
}
