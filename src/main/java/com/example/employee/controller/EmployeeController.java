package com.example.employee.controller;

import com.example.employee.model.Employee;
import com.example.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping({"/", "/employees"})
    public String listEmployees(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "employee-list";
    }

    @GetMapping("/employee/form")
    public String showForm(@RequestParam(value = "id", required = false) Integer id, Model model) {
        if (id != null) {
            model.addAttribute("employee", employeeService.getEmployeeById(id).orElse(new Employee()));
        } else {
            model.addAttribute("employee", new Employee());
        }
        return "employee-form";
    }

    @PostMapping("/employee/save")
    public String saveEmployee(@ModelAttribute Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/employees";
    }

    @GetMapping("/employee/edit")
    public String editEmployee(@RequestParam("id") int id, Model model) {
        model.addAttribute("employee", employeeService.getEmployeeById(id).orElse(new Employee()));
        return "employee-form";
    }

    @GetMapping("/employee/delete")
    public String deleteEmployee(@RequestParam("id") int id) {
        employeeService.deleteEmployee(id);
        return "redirect:/employees";
    }
}
