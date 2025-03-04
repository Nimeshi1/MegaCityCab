package com.system.MegaCityCab.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.system.MegaCityCab.model.Car;

@Repository

public interface CarRepository extends MongoRepository<Car,String>{
   
    
} 