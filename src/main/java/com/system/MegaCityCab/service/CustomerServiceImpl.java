package com.system.MegaCityCab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.system.MegaCityCab.model.Customer;
import com.system.MegaCityCab.repository.CustomerRepository;
import com.system.MegaCityCab.repository.DriverRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public boolean isEmailTaken(String email) {
        return customerRepository.existsByEmail(email) || 
               driverRepository.existsByEmail(email);
    }


    @Override
    public ResponseEntity<?>  createCustomer(Customer customer) {
        if (isEmailTaken(customer.getEmail())) {
            return ResponseEntity.badRequest()
                .body("Email already exists: " + customer.getEmail());
        }
        String encodedPassword = passwordEncoder.encode(customer.getPassword());
        customer.setPassword(encodedPassword);
        return ResponseEntity.ok(customerRepository.save(customer));
    }

    @Override
    public void deleteCustomer(String customerId) {
       
            customerRepository.deleteById(customerId);
        
        
    }

    @Override
    public List<Customer> getAllCustomers() {
        
            return customerRepository.findAll();
    
}

    @Override
    public Customer updateCustomer(String customerId, Customer customer) {
        
            Customer existingCustomer = getCustomerById(customerId);

            existingCustomer.setCustomerNic(customer.getCustomerNic());
            existingCustomer.setCustomerName(customer.getCustomerName());
            existingCustomer.setCustomerAddress(customer.getCustomerAddress());
            existingCustomer.setEmail(customer.getEmail());
            existingCustomer.setCustomerPhone(customer.getCustomerPhone());
            existingCustomer.setPassword(customer.getPassword());
                        return existingCustomer;
        }

    @Override
    public Customer getCustomerById(String customerId) {
        return customerRepository.findById(customerId)
        .orElseThrow(() -> new RuntimeException("Customer not found with ID:"+customerId));
    }
    
    
}
