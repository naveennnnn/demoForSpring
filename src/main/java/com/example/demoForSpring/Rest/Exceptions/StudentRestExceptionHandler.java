package com.example.demoForSpring.Rest.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demoForSpring.Models_entity.StudentErrorResponse;

@ControllerAdvice
public class StudentRestExceptionHandler {
    

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handler(StudentNotFoundException exc){
        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatusCode(HttpStatus.NOT_FOUND.value());
        error.setErrorMessage(exc.getMessage());
        error.setTimeStampl(System.currentTimeMillis());

        return new ResponseEntity(error,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handler1(Exception exc){
        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatusCode(HttpStatus.BAD_REQUEST.value());
        error.setErrorMessage(exc.getMessage());
        error.setTimeStampl(System.currentTimeMillis());

        return new ResponseEntity(error,HttpStatus.BAD_REQUEST);
    }
}
