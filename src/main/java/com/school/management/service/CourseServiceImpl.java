package com.school.management.service;

import com.school.management.entity.Course;
import com.school.management.entity.Student;
import com.school.management.exception.CourseNotFoundException;
import com.school.management.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CourseServiceImpl implements CourseService{
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    StudentService studentService;
    @Override
    public Course getCourse(Long id) {
        Optional<Course> course = courseRepository.findById(id);
        return unwrapCourse(course, id);
    }

    @Override
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

    @Override
    public List<Course> getCourses() {
        return (List<Course>)courseRepository.findAll();
    }

    @Override
    public Course addStudentToCourse(Long studentId, Long courseId){
       Optional<Course> course = courseRepository.findById(courseId);
        Student student = studentService.getStudent(studentId);
       Course unwrappedCourse = unwrapCourse(course, courseId);
       unwrappedCourse.getStudents().add(student);
       return courseRepository.save(unwrappedCourse);

    }
    @Override
    public Set<Student> getEnrolledStudent(Long courseId){
        Course course = getCourse(courseId);
        return course.getStudents();
    }
    static Course unwrapCourse(Optional<Course> entity, Long id) {
        if (entity.isPresent()) return entity.get();
        else throw new CourseNotFoundException(id);
    }
}
