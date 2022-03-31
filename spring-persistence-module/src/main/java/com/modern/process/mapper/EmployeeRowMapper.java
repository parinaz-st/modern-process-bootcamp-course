package com.modern.process.mapper;

import com.modern.process.entity.Employee;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeRowMapper implements RowMapper<Employee> {
    @Override
    public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
        Employee employee = new Employee();

        employee.setId(resultSet.getInt("id"));
        employee.setFirstname(resultSet.getString("first_name"));
        employee.setLastname(resultSet.getString("last_name"));
        employee.setAddress(resultSet.getString("address"));
        employee.setEmail(resultSet.getString("email"));

        return employee;
    }
}

