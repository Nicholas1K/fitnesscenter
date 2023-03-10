package com.spring.fitnesscenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.fitnesscenter.model.AddressPersonalT;

public interface AddressPTRepository extends JpaRepository<AddressPersonalT,Long> {
    
}
