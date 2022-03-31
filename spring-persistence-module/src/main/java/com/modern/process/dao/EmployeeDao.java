package com.modern.process.dao;

import com.modern.process.entity.Employee;

import java.util.List;

public interface EmployeeDao {
    List<Employee> findAll();
}
