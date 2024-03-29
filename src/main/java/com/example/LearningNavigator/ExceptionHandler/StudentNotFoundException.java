package com.example.LearningNavigator.ExceptionHandler;

public class StudentNotFoundException extends RuntimeException{
    public StudentNotFoundException(String message){
        super(message);
    }
}
