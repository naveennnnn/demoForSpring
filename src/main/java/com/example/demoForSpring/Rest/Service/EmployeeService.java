package com.example.demoForSpring.Rest.Service;

import java.util.List;

import com.example.demoForSpring.Models_entity.Employee;

public interface EmployeeService {
 
    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee theEmployee);

    void delete(int id);
}
