package com.jvstutcode.service;

import com.jvstutcode.excpetions.CustomerNotFoundException;
import com.jvstutcode.model.Customer;
import com.jvstutcode.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("customerService")
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public Customer addCustomer(Customer theCustomer) {
        return customerRepository.save(theCustomer);
    }

    public Customer getCustomer(Long theId) {
        return customerRepository.findById(theId)
        .orElseThrow(()-> new CustomerNotFoundException("The requested customer could not be found"));
    }

    public void delete(Long theId) {
        customerRepository.deleteById(theId);
    }
}
