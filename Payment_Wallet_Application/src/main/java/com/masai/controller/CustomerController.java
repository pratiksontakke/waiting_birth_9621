package com.masai.controller;

import com.masai.exception.CustomerException;
import com.masai.model.Customer;
import com.masai.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService cService;
    @PostMapping("/customers")
    public ResponseEntity<Customer> saveCustomer(@Valid @RequestBody Customer customer) throws CustomerException {
        Customer savedCustomer= cService.createCustomer(customer);
        return new ResponseEntity<Customer>(savedCustomer, HttpStatus.CREATED);
    }

    @PutMapping("/customers")
    public  ResponseEntity<Customer> updateCustomer(@Valid @RequestBody Customer customer, @Valid @RequestParam String key ) throws CustomerException {
        Customer updatedCustomer= cService.updateCustomer(customer, key);
        return new ResponseEntity<Customer>(updatedCustomer,HttpStatus.ACCEPTED);
    }

}

