package com.example.demoForSpring.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demoForSpring.Models_entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>{
    // No need to add any default methods.
}
