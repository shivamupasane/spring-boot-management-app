package com.school.management.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(Long id){
        super("user with " +  id + " not present in records");
    }
}
