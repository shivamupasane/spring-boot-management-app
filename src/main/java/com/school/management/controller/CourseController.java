package com.school.management.controller;


import com.school.management.entity.Course;
import com.school.management.entity.Student;
import com.school.management.service.CourseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(path="/course")
public class CourseController {
    @Autowired
    CourseService courseService;
    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourse(@Valid @PathVariable Long id) {
        return new ResponseEntity<>(courseService.getCourse(id),  HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Course> saveCourse(@Valid @RequestBody Course course) {
        return new ResponseEntity<>(courseService.saveCourse(course), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCourse(@Valid @PathVariable Long id) {
        courseService.deleteCourse(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Course>> getCourses() {
        return new ResponseEntity<>(courseService.getCourses(),HttpStatus.OK);
    }
    @PutMapping("/{courseId}/student/{studentId}")
    public ResponseEntity<Course> enrollStudentToCourse(@PathVariable Long courseId, @PathVariable Long studentId) {
        return new ResponseEntity<>(courseService.addStudentToCourse(studentId, courseId),  HttpStatus.OK);
    }
    @GetMapping("/{courseId}/students")
    public ResponseEntity<Set<Student>> getEnrolledStudents(@Valid @PathVariable Long courseId) {
        return new ResponseEntity<>(courseService.getEnrolledStudent(courseId),  HttpStatus.OK);
    }
}
