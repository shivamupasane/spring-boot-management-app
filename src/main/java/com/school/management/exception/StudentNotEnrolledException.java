package com.school.management.exception;

public class StudentNotEnrolledException extends RuntimeException{
    public StudentNotEnrolledException(Long studentId, Long courseId){
        super("Student with id: "+ studentId + "not enrolled in course with id: " + courseId);
    }
}
