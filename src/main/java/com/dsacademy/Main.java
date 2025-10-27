package com.dsacademy;

import com.dsacademy.model.Employee;
import com.dsacademy.service.EmployeeService;
import com.dsacademy.service.FileService;
import com.dsacademy.util.EmployeeNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        EmployeeService employeeService = new EmployeeService();
        FileService fileService = new FileService();

        List<Employee> employees = new ArrayList<>();

        // Генерируем тестовых сотрудников
        for (int i = 0; i < 10; i++) {
            employees.add(new Employee(i, "Ivan" + i, "Ivanov" + i, i * 10000));
        }

        // Поиск сотрудника по ID (успешный случай)
        Employee employeeById = employeeService.getEmployeeById(3, employees);
        System.out.println(employeeById);

        // Поиск сотрудника по ID (случай с исключением)
        try {
            Employee employeeById1 = employeeService.getEmployeeById(11, employees);
            System.out.println(employeeById1);
        } catch (EmployeeNotFoundException e) {
            System.out.println("\n" + e.getMessage() + "\n");
        }

        // Создаем Map сотрудников
        Map<String, Employee> employeeMap = employeeService.getEmployeeMap(employees);
        System.out.println(employeeMap + "\n");

        // Фильтруем сотрудников по зарплате
        List<Employee> salaryGreaterThan = employeeService.getEmployeeBySalaryGreaterThan(40000, employees);
        System.out.println(salaryGreaterThan + "\n");

        // Сохраняем сотрудников в файл
        fileService.saveEmployeeToFile(employees, "employees.txt");

        // Загружаем сотрудников из файла
        List<Employee> loaded = fileService.loadEmployeesFromFile("employees.txt");
        System.out.println(loaded);
    }
}