package com.dsacademy.service;

import com.dsacademy.model.Employee;
import com.dsacademy.util.EmployeeNotFoundException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EmployeeServiceTest {
    private EmployeeService employeeService = new EmployeeService();
    private List<Employee> employees = Arrays.asList(
            new Employee(1, "John", "Doe", 50000),
            new Employee(2, "Jane", "Smith", 30000)
    );

    @Test
    void findExistingEmployee() {
        Employee result = employeeService.getEmployeeById(1, employees);
        assertEquals(1, result.getId());
    }

    @Test
    void throwWhenEmployeeNotFound() {
        assertThrows(EmployeeNotFoundException.class,
                () -> employeeService.getEmployeeById(100, employees));
    }

    @Test
    void filterEmployeeBySalary() {
        List<Employee> result = employeeService.getEmployeeBySalaryGreaterThan(40000, employees);
        assertEquals(1, result.size());
        assertEquals(50000, result.getFirst().getSalary());
    }

    @Test
    void throwWhenListIsNull() {
        assertThrows(IllegalArgumentException.class,
                () -> employeeService.getEmployeeBySalaryGreaterThan(10000, null));
    }
}
