package com.example.employee.controller;

import com.example.employee.dao.EmployeeDAO;
import com.example.employee.model.Employee;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class EmployeeController implements Controller {

    private EmployeeDAO employeeDAO;

    public void setEmployeeDAO(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    // Main entry point for SimpleControllerHandlerAdapter
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String path = request.getServletPath();
        try {
            if ("/employees".equals(path)) {
                List<Employee> list = employeeDAO.getAllEmployees();
                request.setAttribute("employees", list);
                request.getRequestDispatcher("/WEB-INF/views/employee-list.jsp").forward(request, response);
            } else if ("/employee/form".equals(path)) {
                request.setAttribute("employee", new Employee());
                request.getRequestDispatcher("/WEB-INF/views/employee-form.jsp").forward(request, response);
            } else if ("/employee/save".equals(path)) {
                String idStr = request.getParameter("id");
                String name = request.getParameter("name");
                String department = request.getParameter("department");
                String salaryStr = request.getParameter("salary");
                Employee employee = new Employee();
                if (idStr != null && !idStr.isEmpty()) {
                    employee.setId(Integer.parseInt(idStr));
                }
                employee.setName(name);
                employee.setDepartment(department);
                if (salaryStr != null && !salaryStr.isEmpty()) {
                    employee.setSalary(Double.parseDouble(salaryStr));
                }
                if (employee.getId() > 0) {
                    employeeDAO.updateEmployee(employee);
                } else {
                    employeeDAO.saveEmployee(employee);
                }
                response.sendRedirect(request.getContextPath() + "/employees");
            } else if ("/employee/edit".equals(path)) {
                String idStr = request.getParameter("id");
                if (idStr != null && !idStr.isEmpty()) {
                    int id = Integer.parseInt(idStr);
                    Employee employee = employeeDAO.getEmployeeById(id);
                    request.setAttribute("employee", employee);
                }
                request.getRequestDispatcher("/WEB-INF/views/employee-form.jsp").forward(request, response);
            } else if ("/employee/delete".equals(path)) {
                String idStr = request.getParameter("id");
                if (idStr != null && !idStr.isEmpty()) {
                    int id = Integer.parseInt(idStr);
                    employeeDAO.deleteEmployee(id);
                }
                response.sendRedirect(request.getContextPath() + "/employees");
            } else if ("/".equals(path)) {
                response.sendRedirect(request.getContextPath() + "/employees");
            } else {
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
            }
        } catch (Exception e) {
            throw new IOException(e);
        }
        return null;
    }
}
