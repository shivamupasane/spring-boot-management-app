package com.school.management.exception;

public class GradeNotFoundException extends RuntimeException{
    public GradeNotFoundException(Long studentId, Long courseId) {
        super("Grade for student:"+ studentId + "for course:" + courseId + "does not exists");
    }
}
