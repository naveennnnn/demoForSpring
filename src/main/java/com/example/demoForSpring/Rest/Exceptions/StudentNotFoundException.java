package com.example.demoForSpring.Rest.Exceptions;

public class StudentNotFoundException extends RuntimeException{
    
    public StudentNotFoundException(String message){
        super(message);
    }
}
