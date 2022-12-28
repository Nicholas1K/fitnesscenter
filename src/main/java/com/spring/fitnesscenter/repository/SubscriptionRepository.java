package com.spring.fitnesscenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.fitnesscenter.model.Subscription;



public interface SubscriptionRepository extends JpaRepository<Subscription,Long> {
    
}
