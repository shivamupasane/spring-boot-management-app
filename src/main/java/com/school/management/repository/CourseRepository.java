package com.school.management.repository;

import com.school.management.entity.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CourseRepository extends CrudRepository<Course, Long>{
}
