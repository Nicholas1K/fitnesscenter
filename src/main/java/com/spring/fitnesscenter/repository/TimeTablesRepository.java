package com.spring.fitnesscenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.fitnesscenter.model.TimeTables;



public interface TimeTablesRepository extends JpaRepository<TimeTables,Long> {
    
}
