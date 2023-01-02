package com.school.management.controller;

import com.school.management.entity.Course;
import com.school.management.entity.Student;
import com.school.management.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(path = "/student")
public class StudentController {
  @Autowired
  StudentService studentService;

  @GetMapping("/{id}")
  private ResponseEntity<Student> getStudent(@PathVariable Long id){
    return new ResponseEntity<>(studentService.getStudent(id), HttpStatus.OK);
  }
  @PostMapping
    private ResponseEntity<Student> saveStudent(@Valid  @RequestBody Student student){
      return new ResponseEntity<>(studentService.saveStudent(student), HttpStatus.CREATED);
  }
  @DeleteMapping("/{id}")
    private ResponseEntity<HttpStatus> deleteStudent(@PathVariable Long id){
      studentService.deleteStudent(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
    @GetMapping("/all")
    private ResponseEntity<List <Student>> getStudents(){
    return new ResponseEntity<>(studentService.getStudents(),HttpStatus.OK);
    }
  @GetMapping("/{studentId}/courses")
  private ResponseEntity<Set<Course>> getEnrolledCourses(@PathVariable Long studentId){
    return new ResponseEntity<>(studentService.getEnrolledCourses(studentId),HttpStatus.OK);
  }
}
