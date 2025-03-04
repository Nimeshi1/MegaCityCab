package com.system.MegaCityCab.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.system.MegaCityCab.model.Customer;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String>{
    Optional<Customer> findByEmail(String email); 
    boolean existsByEmail (String email);
} 