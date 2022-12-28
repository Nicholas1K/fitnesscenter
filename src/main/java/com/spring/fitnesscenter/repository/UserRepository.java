package com.spring.fitnesscenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.fitnesscenter.model.User;



public interface UserRepository extends JpaRepository<User,Long> {
    
}
