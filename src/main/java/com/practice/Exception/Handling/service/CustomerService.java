package com.practice.Exception.Handling.service;

import com.practice.Exception.Handling.model.Customer;
import com.practice.Exception.Handling.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public  CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    public ResponseEntity<List<Customer>> getCustomers(){
        List<Customer> customers  =  this.customerRepository.findAll();
    if( customers.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    return new ResponseEntity<>(customers,HttpStatus.OK);


    }

    public Customer addCustomer(Customer customer){
        return this.customerRepository.save(customer);
    }
}
