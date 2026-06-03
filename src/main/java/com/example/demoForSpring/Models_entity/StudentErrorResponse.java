package com.example.demoForSpring.Models_entity;

public class StudentErrorResponse {
    
    private int statusCode;
    private String errorMessage;
    private long timeStampl;

    public StudentErrorResponse(){}

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public long getTimeStampl() {
        return timeStampl;
    }

    public void setTimeStampl(long timeStampl) {
        this.timeStampl = timeStampl;
    }

    
}
