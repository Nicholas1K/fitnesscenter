package com.spring.fitnesscenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.fitnesscenter.model.DayWeek;



public interface DayWeekRepository extends JpaRepository<DayWeek,Long> {
    
}
