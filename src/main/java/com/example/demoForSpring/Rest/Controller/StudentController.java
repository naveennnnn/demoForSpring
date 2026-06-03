package com.example.demoForSpring.Rest.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.GetExchange;

import com.example.demoForSpring.Models_entity.Student;
import com.example.demoForSpring.Models_entity.StudentErrorResponse;
import com.example.demoForSpring.Rest.Exceptions.StudentNotFoundException;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api")
public class StudentController {

    private List<Student> theStudents;

    @PostConstruct
    public void loadStudents(){
        theStudents = new ArrayList<>();

        theStudents.add(new Student("Naveen","B","email","url"));
        theStudents.add(new Student("Arun","C","email","url"));
    }
    
    @GetMapping("/students")
    public List<Student> getStudents(){
        return theStudents;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){

        if(studentId>= theStudents.size() || studentId<0){
            throw new StudentNotFoundException("The entered student Id: "+studentId+" is Invalid.");
        }
        return theStudents.get(studentId);
    }
}
