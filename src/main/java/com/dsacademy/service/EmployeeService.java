package com.dsacademy.service;

import com.dsacademy.model.Employee;
import com.dsacademy.util.EmployeeNotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeService {
    public Employee getEmployeeById(int id, List<Employee> employees) {
        if (employees == null || employees.isEmpty()) {
            throw new IllegalArgumentException("Employee list cannot be null or empty");
        }

        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        throw new EmployeeNotFoundException("Employee with id " + id + " not found!");
    }

    public List<Employee> getEmployeeBySalaryGreaterThan(int targetSalary, List<Employee> employees) {
        if (employees == null || employees.isEmpty()) {
            throw new IllegalArgumentException("Employee list cannot be null or empty");
        }

        List<Employee> employeeList = new ArrayList<>();

        for (Employee employee : employees) {
            if (employee.getSalary() >= targetSalary) {
                employeeList.add(employee);
            }
        }

        return employeeList;
    }

    public Map<String, Employee> getEmployeeMap(List<Employee> employees) {
        if (employees == null || employees.isEmpty()) {
            throw new IllegalArgumentException("Employee list cannot be null or empty");
        }

        Map<String, Employee> employeeMap = new HashMap<>();

        for (Employee employee : employees) {
            String key = "id" + employee.getId();

            // Критически важно: проверка на дубликаты ID
            if (employeeMap.containsKey(key)) {
                throw new IllegalStateException("Duplicate employee ID found: " + employee.getId());
            }

            employeeMap.put(key, employee);
        }

        return employeeMap;
    }
}
