package com.school.management.service;

import com.school.management.entity.Course;
import com.school.management.entity.Student;

import java.util.List;
import java.util.Set;

public interface CourseService {
    Course getCourse(Long id);
    Course saveCourse(Course course);
    void deleteCourse(Long id);
    List<Course> getCourses();
    Course addStudentToCourse(Long studentId, Long courseId);
    Set<Student> getEnrolledStudent(Long courseId);
}
