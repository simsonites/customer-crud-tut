package com.jvstutcode.controller;

import com.jvstutcode.model.Customer;
import com.jvstutcode.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    private final CustomerService customerService;
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getCustomers(){
        List<Customer> customers = customerService.getCustomers();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable("id") Long theId){
        Customer theCustomer = customerService.getCustomer(theId);
        return new ResponseEntity<>(theCustomer , HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer theCustomer){
           Customer newCustomer = customerService.addCustomer(theCustomer);
        return new ResponseEntity<>(newCustomer, HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer theCustomer){
        Customer newCustomer = customerService.addCustomer(theCustomer);
        return new ResponseEntity<>(newCustomer, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable("id") Long theId){
              customerService.delete(theId);
        return new ResponseEntity<>(HttpStatus.OK);
    }





}
