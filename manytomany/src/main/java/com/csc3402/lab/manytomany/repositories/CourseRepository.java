package com.csc3402.lab.manytomany.repositories;

import com.csc3402.lab.manytomany.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long>{
}
