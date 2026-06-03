package com.example.demoForSpring.Rest.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoForSpring.Models_entity.Employee;
import com.example.demoForSpring.Rest.Service.EmployeeService;
import com.example.demoForSpring.dao.EmployeeDao;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    
    private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        List<Employee> ls = employeeService.findAll();
        return ls;
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        Employee emp = employeeService.findById(employeeId);
        
        if(emp==null){
            throw new RuntimeException("Employee id not found - "+employeeId);
        }
        return emp;
    }

}
