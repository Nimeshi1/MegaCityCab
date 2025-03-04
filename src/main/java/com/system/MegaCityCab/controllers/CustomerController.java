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

import com.system.MegaCityCab.model.Customer;
import com.system.MegaCityCab.service.CustomerService;

@RestController
@RequestMapping("/customers")
@CrossOrigin(origins = "*")

public class CustomerController {

    @Autowired
    private CustomerService customerService;

     @GetMapping("/viewCustomers")
   public ResponseEntity<List<Customer>> getAllCustomers() {
       List<Customer> customers = customerService.getAllCustomers();
       return new ResponseEntity<>(customers, HttpStatus.OK);
   }

   @GetMapping("/{customerId}")
   public ResponseEntity<Customer> getCustomerById(@PathVariable String customerId) {
       Customer customer = customerService.getCustomerById(customerId);
       return new ResponseEntity<>(customer, HttpStatus.OK);
   }

   @PostMapping("/createCustomer")
   public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
       Customer createdCustomer = customerService.createCustomer(customer);
       return new ResponseEntity<>(createdCustomer, HttpStatus.CREATED);
   }

   @PutMapping("/updateCustomer/{customerId}")
   public ResponseEntity<Customer> updateCustomer(
           @PathVariable String customerId,
           @RequestBody Customer customer) {
       Customer updatedCustomer = customerService.updateCustomer(customerId, customer);
       return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
   }

}
