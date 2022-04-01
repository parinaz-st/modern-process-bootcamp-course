package com.modern.process.dao;

import com.modern.process.entity.Employee;
import com.modern.process.mapper.EmployeeRowMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{
    private NamedParameterJdbcTemplate template;

    public EmployeeDaoImpl(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    @Override
    public List<Employee> findAll() {
        return template.query("select * from employee", new EmployeeRowMapper());
//        return null;
    }

    @Override
    public void insertEmployee(Employee employee) {
        String insertQuery = "insert into employee (first_name, last_name, address, email)" +
                "values(:first_name, :last_name, :address, :email)";

        KeyHolder keyHolder = new GeneratedKeyHolder();
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("first_name", employee.getFirstname())
                .addValue("last_name", employee.getLastname())
                .addValue("address", employee.getAddress())
                .addValue("email", employee.getEmail());

        template.update(insertQuery, params, keyHolder);
    }

    @Override
    public void employeeUpdate(Employee employee) {
        String sql = "update employee set first_name = :first_name, last_name = :last_name" +
                ", address = :address, email = :email" +
                " where id = :id";
        Map<String, Object> map = new HashMap<>();
        map.put("id", employee.getId());
        map.put("first_name", employee.getFirstname());
        map.put("last_name", employee.getLastname());
        map.put("address", employee.getAddress());
        map.put("email", employee.getEmail());

        template.execute(sql, map, new PreparedStatementCallback<Object>() {
            @Override
            public Object doInPreparedStatement(PreparedStatement preparedStatement) throws SQLException, DataAccessException {
                return preparedStatement.executeUpdate();
            }
        });

    }

    @Override
    public void deleteEmployee(Employee employee) {
        String sql = "delete from employee where id = :id";
        Map<String, Object> map = new HashMap<>();

        map.put("id", employee.getId());

        template.execute(sql, map, new PreparedStatementCallback<Object>() {
            @Override
            public Object doInPreparedStatement(PreparedStatement preparedStatement) throws SQLException, DataAccessException {
                return preparedStatement.executeUpdate();
            }
        });

    }
}
