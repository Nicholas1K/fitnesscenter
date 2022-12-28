package com.spring.fitnesscenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.fitnesscenter.model.Course;

public interface CourseRepository extends JpaRepository<Course,Long> {
    
}
