package com.example.demoForSpring.dao;

import java.util.List;

import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demoForSpring.Models_entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class StudentDaoImpl implements StudentDAO{

    private EntityManager entityManager;

    @Autowired
    public StudentDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override // @Transactional is not required since we are not performing any data modification query
    public Student findById(int id) {
        return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findAll(){
        TypedQuery<Student> query = entityManager.createQuery("From Student",Student.class); //THe from (Student)-> is not the database table name but the entity name, here in query we should only use entityName and entityFieldName and not the database.
        return query.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {

        entityManager.merge(student);

        Query query = entityManager.createQuery("update Student s set s.lastName = 'LEVEL' where s.id=:Id");
        query.setParameter("Id",student.getId());
        int numRowsUpdated = query.executeUpdate();
        
        System.out.println(numRowsUpdated);
    }

    @Override
    @Transactional
    public void delete(int id) {
        Student managedStudent = entityManager.find(Student.class,id);
        entityManager.remove(managedStudent);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int numRowsDeleted = entityManager.createQuery("Delete FROM Student").executeUpdate();
        return numRowsDeleted;
    }
    
}
