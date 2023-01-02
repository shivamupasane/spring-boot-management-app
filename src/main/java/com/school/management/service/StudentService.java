package com.school.management.service;

import com.school.management.entity.Course;
import com.school.management.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

public interface StudentService {
    Student getStudent(Long id);
    Student saveStudent(Student student);
    void deleteStudent(Long id);
    List<Student> getStudents();
    Set<Course>  getEnrolledCourses(Long studentId);
}
