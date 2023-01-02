package com.school.management.exception;

public class CourseNotFoundException extends RuntimeException{
    public CourseNotFoundException(Long id) {
        super("Course with" + id + "does not exists");
    }
}
