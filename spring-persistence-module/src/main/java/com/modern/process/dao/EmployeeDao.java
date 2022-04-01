package com.modern.process.dao;

import com.modern.process.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;
public interface EmployeeDao {
    List<Employee> findAll();

    void insertEmployee(Employee employee);
    void employeeUpdate(Employee employee);
    void deleteEmployee(Employee employee);
}
