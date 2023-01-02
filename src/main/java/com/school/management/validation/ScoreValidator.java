package com.school.management.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.List;

public class ScoreValidator implements ConstraintValidator<Score, String> {
    List<String> scoreList = Arrays.asList("A", "A+", "B", "B+", "C", "C+", "D", "D+");
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        boolean isValid = false;
        for(String grade : scoreList){
            isValid = s.equals(grade);
            if(isValid) break;
        }
        return isValid;
    }
}
