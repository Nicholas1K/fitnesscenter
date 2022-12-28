package com.spring.fitnesscenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.fitnesscenter.model.DayAndTimeWork;



public interface DayAndTimeWorkRepository extends JpaRepository<DayAndTimeWork,Long> {
    
}
