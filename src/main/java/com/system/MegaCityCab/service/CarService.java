package com.system.MegaCityCab.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.system.MegaCityCab.model.Car;


@Service
public interface CarService {
    List<Car>getAllCars();

    Car getCarById(String carId);

    Car createCar(Car car);

    Car updateCar(String carId,Car car);

    void deleteCar(String carId);
    
}
