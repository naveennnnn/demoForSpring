package com.example.demoForSpring.dao;

import java.util.List;

import com.example.demoForSpring.Models_entity.Student;

public interface StudentDAO {
    void save(Student student);

    Student findById(int id);

    List<Student> findAll();

    void update(Student student);

    void delete(int id);

    int deleteAll();
}
