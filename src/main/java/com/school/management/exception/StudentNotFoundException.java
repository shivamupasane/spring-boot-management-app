package com.school.management.exception;

public class StudentNotFoundException extends RuntimeException{
    public StudentNotFoundException(Long id){
        super("Student with" + id + "does not exists");
    }
}
