package com.spring.fitnesscenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.fitnesscenter.model.Address;

public interface AddressRepository extends JpaRepository<Address,Long> {
    
}
