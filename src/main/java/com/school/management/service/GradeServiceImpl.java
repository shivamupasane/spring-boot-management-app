package com.school.management.service;

import com.school.management.entity.Course;
import com.school.management.entity.Grade;
import com.school.management.entity.Student;
import com.school.management.exception.GradeNotFoundException;
import com.school.management.exception.StudentNotEnrolledException;
import com.school.management.repository.CourseRepository;
import com.school.management.repository.GradeRepository;
import com.school.management.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GradeServiceImpl implements GradeService{
    @Autowired
    GradeRepository gradeRepository;
    @Autowired
    StudentService studentService;
    @Autowired
    CourseService courseService;

    @Override
    public Grade getGrade(Long studentId, Long courseId) {
        Optional<Grade> grade = gradeRepository.findByStudentIdAndCourseId(studentId, courseId);
        return unwrapGrade(grade, studentId, courseId);

    }

    @Override
    public Grade saveGrade(Grade grade, Long studentId, Long courseId) {
        Student student = studentService.getStudent(studentId);
        Course course = courseService.getCourse(courseId);
        if(!student.getCourses().contains(course)) throw new StudentNotEnrolledException(studentId, courseId);
        grade.setCourse(course);
        grade.setStudent(student);
        return gradeRepository.save(grade);
    }

    @Override
    public Grade updateGrade(String score, Long studentId, Long courseId) {
        Optional<Grade> grade = gradeRepository.findByStudentIdAndCourseId(studentId, courseId);
        Grade unwrappedGrade = unwrapGrade(grade, studentId, courseId);
        unwrappedGrade.setScore(score);
        return gradeRepository.save(unwrappedGrade);
    }

    @Override
    public void deleteGrade(Long studentId, Long courseId) {
        gradeRepository.deleteByStudentIdAndCourseId(studentId, courseId);
    }

    @Override
    public List<Grade> getStudentGrades(Long studentId) {
            return  gradeRepository.findByStudentId(studentId);
    }

    @Override
    public List<Grade> getCourseGrades(Long courseId) {
            return gradeRepository.findByCourseId(courseId);
    }

    @Override
    public List<Grade> getAllGrades() {
        return (List<Grade>)gradeRepository.findAll();
    }
    static Grade unwrapGrade(Optional<Grade> entity, Long studentId, Long courseId) {
        if (entity.isPresent()) return entity.get();
        else throw new GradeNotFoundException(studentId, courseId);
    }
}
