package com.example.employee.service;

import com.example.employee.dao.EmployeeDAO;
import com.example.employee.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeService(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    public List<Employee> getAllEmployees() {
        return employeeDAO.findAll();
    }

    public Optional<Employee> getEmployeeById(int id) {
        return employeeDAO.findById(id);
    }

    public Employee saveEmployee(Employee employee) {
        return employeeDAO.save(employee);
    }

    public void deleteEmployee(int id) {
        employeeDAO.deleteById(id);
    }
}

