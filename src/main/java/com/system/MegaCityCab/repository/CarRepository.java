package com.system.MegaCityCab.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.system.MegaCityCab.model.Car;

@Repository

public interface CarRepository extends MongoRepository<Car,String>{
    List<Car> findByAvailable(boolean available);
    List<Car> findByAssignedDriverId(String assignedDriverId);
    
} 