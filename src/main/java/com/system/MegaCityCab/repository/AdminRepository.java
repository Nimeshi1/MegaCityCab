package com.system.MegaCityCab.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.system.MegaCityCab.model.Admin;

@Repository

public interface AdminRepository extends MongoRepository<Admin,String>{

    Optional<Admin> findByEmail(String email);

    
} 
    

