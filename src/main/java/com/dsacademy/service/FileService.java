package com.dsacademy.service;

import com.dsacademy.model.Employee;
import com.dsacademy.util.FileLoadException;
import com.dsacademy.util.InvalidFormatException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileService {
    public void saveEmployeeToFile(List<Employee> employees, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Employee employee : employees) {
                String record = employee.getId() + "," +
                        employee.getFirstName() + "," +
                        employee.getLastName() + "," +
                        employee.getSalary();
                writer.write(record);
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Error saving employees to file: " + filename, e);
        }
    }

    public List<Employee> loadEmployeesFromFile(String filename) {
        List<Employee> employees = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;

            while ((line = reader.readLine()) != null) {
                // Пропуск пустых строк
                if (line.trim().isEmpty()) continue;

                try {
                    Employee employee = parseEmployeeLine(line);
                    employees.add(employee);
                } catch (InvalidFormatException e) {
                    System.out.println("Error in line!");
                }
            }
            return employees;
        } catch (FileNotFoundException e) {
            throw new FileLoadException("File not found: " + filename, e);
        } catch (IOException e) {
            throw new FileLoadException("Error reading file: " + filename, e);
        }
    }

    // Метод парсинга с валидацией
    private Employee parseEmployeeLine(String line) {
        try {
            String[] parts = line.split(",");

            if (parts.length != 4) {
                throw new InvalidFormatException("Invalid number of fields. Expected 4, got " + parts.length);
            }

            int id = Integer.parseInt(parts[0].trim());
            String firstName = parts[1].trim();
            String lastName = parts[2].trim();
            int salary = Integer.parseInt(parts[3].trim());

            return new Employee(id, firstName, lastName, salary);
        } catch (NumberFormatException e) {
            throw new InvalidFormatException("Invalid number format: " + e.getMessage());
        }
    }
}
