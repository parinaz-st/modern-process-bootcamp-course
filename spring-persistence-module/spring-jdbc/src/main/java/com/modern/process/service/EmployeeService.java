package com.modern.process.service;

import com.modern.process.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
public interface EmployeeService {
    List<Employee> findAll();

    void createEmployee(Employee employee);
    void updateEmployee(Employee employee);
    void deleteEmployee(Employee employee);
}
