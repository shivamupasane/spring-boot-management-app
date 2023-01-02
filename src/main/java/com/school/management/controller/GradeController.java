package com.school.management.controller;

import com.school.management.entity.Grade;
import com.school.management.service.GradeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/grade")
public class GradeController {
    @Autowired
    GradeService gradeService;
    @GetMapping("/student/{studentId}/course/{courseId}")
     private ResponseEntity<Grade> getGrade(@PathVariable Long studentId, @PathVariable Long courseId){
        return new ResponseEntity<>(gradeService.getGrade(studentId, courseId), HttpStatus.OK);
    }
    @PostMapping("/student/{studentId}/course/{courseId}")
    private ResponseEntity<Grade> saveGrade(@PathVariable Long studentId, @PathVariable Long courseId, @Valid @RequestBody Grade grade){
        return new ResponseEntity<>(gradeService.saveGrade(grade, studentId, courseId), HttpStatus.CREATED);
    }
    @PutMapping("/student/{studentId}/course/{courseId}")
    private ResponseEntity<Grade> updateGrade(@PathVariable Long studentId, @PathVariable Long courseId, @Valid @RequestBody Grade grade){
        return new ResponseEntity<>(gradeService.updateGrade(grade.getScore(), studentId, courseId), HttpStatus.OK);
    }
    @DeleteMapping("/student/{studentId}/course/{courseId}")
    private ResponseEntity<Grade> deleteGrade(@PathVariable Long studentId, @PathVariable Long courseId){
        gradeService.deleteGrade(studentId, courseId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/student/{studentId}")
    private ResponseEntity<List<Grade>> getStudentGrades(@PathVariable Long studentId){
        return new ResponseEntity<>(gradeService.getStudentGrades(studentId), HttpStatus.OK);
    }
    @GetMapping("/course/{courseId}")
    private ResponseEntity<List<Grade>> getCourseGrades(@PathVariable Long courseId){
        return new ResponseEntity<>(gradeService.getCourseGrades(courseId), HttpStatus.OK);
    }
    @GetMapping("/all")
    private ResponseEntity<List<Grade>> getGrades(){
        return new ResponseEntity<>(gradeService.getAllGrades(), HttpStatus.OK);
    }
}
