package com.spring.fitnesscenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.fitnesscenter.model.Payment;



public interface PaymentRepository extends JpaRepository<Payment,Long> {
    
}
