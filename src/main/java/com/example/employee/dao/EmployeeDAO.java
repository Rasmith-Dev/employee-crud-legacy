package com.example.employee.dao;

import com.example.employee.model.Employee;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class EmployeeDAO {

    private JdbcTemplate jdbcTemplate;

    public EmployeeDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Employee> getAllEmployees() {
        String sql = "SELECT * FROM employee";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Employee.class));
    }

    public Employee getEmployeeById(int id) {
        String sql = "SELECT * FROM employee WHERE id=?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Employee.class), id);
    }

    public void saveEmployee(Employee employee) {
        if (employee.getId() > 0) {
            String sql = "UPDATE employee SET name=?, department=?, salary=? WHERE id=?";
            jdbcTemplate.update(sql, employee.getName(), employee.getDepartment(), employee.getSalary(), employee.getId());
        } else {
            String sql = "INSERT INTO employee(name, department, salary) VALUES(?,?,?)";
            jdbcTemplate.update(sql, employee.getName(), employee.getDepartment(), employee.getSalary());
        }
    }

    public void updateEmployee(Employee employee) {
        String sql = "UPDATE employee SET name=?, department=?, salary=? WHERE id=?";
        jdbcTemplate.update(sql, employee.getName(), employee.getDepartment(), employee.getSalary(), employee.getId());
    }

    public void deleteEmployee(int id) {
        String sql = "DELETE FROM employee WHERE id=?";
        jdbcTemplate.update(sql, id);
    }
}
