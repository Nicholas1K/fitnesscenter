package com.spring.fitnesscenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.fitnesscenter.model.PersonalTrainer;



public interface PersonalTrainerRepository extends JpaRepository<PersonalTrainer,Long> {
    
}
