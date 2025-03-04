package com.system.MegaCityCab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.MegaCityCab.model.Customer;
import com.system.MegaCityCab.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public Customer createCustomer(Customer customer) {
       
            return customerRepository.save(customer);
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

            existingCustomer.setCustomerName(customer.getCustomerName());
            existingCustomer.setEmail(customer.getEmail());
            existingCustomer.setCustomerpNo(customer.getCustomerpNo());
            existingCustomer.setUserName(customer.getUserName());
            existingCustomer.setPassword(customer.getPassword());
                        return existingCustomer;
        }

    @Override
    public Customer getCustomerById(String customerId) {
        return customerRepository.findById(customerId)
        .orElseThrow(() -> new RuntimeException("Customer not found with ID:"+customerId));
    }
    
    
}
