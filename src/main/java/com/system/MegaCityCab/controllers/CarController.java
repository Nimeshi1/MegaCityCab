package com.system.MegaCityCab.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.system.MegaCityCab.model.Car;
import com.system.MegaCityCab.service.CarService;

@RestController
@RequestMapping("/cars")
@CrossOrigin(origins = "*")

public class CarController {
   
    @Autowired
    private CarService carService;

     @GetMapping("/viewCars")
   public ResponseEntity<List<Car>> getAllCars() {
       List<Car> cars = carService.getAllCars();
       return new ResponseEntity<>(cars, HttpStatus.OK);
   }

   @GetMapping("/{carId}")
   public ResponseEntity<Car> getCarById(@PathVariable String carId) {
       Car car = carService.getCarById(carId);
       return new ResponseEntity<>(car, HttpStatus.OK);
   }

   @PostMapping("/createCar")
   public ResponseEntity<Car> createCar(@RequestBody Car car) {
       Car createdCar = carService.createCar(car);
       return new ResponseEntity<>(createdCar, HttpStatus.CREATED);
   }

   @PutMapping("/updateCar/{carId}")
   public ResponseEntity<Car> updateCar(
           @PathVariable String carId,
           @RequestBody Car car) {
       Car updatedCar = carService.updateCar(carId, car);
       return new ResponseEntity<>(updatedCar, HttpStatus.OK);
   }

    
}
