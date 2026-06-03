package com.example.demoForSpring.dao;

import java.util.List;

import com.example.demoForSpring.Models_entity.Employee;

public interface EmployeeDao {
    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee theEmployee);

    void delete(int id);
}
