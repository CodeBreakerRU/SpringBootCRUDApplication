package com.mtit.abcApplication.controller;

import com.mtit.abcApplication.Customer.Domain.Customer;
import com.mtit.abcApplication.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService service;

    @PostMapping("/addCustomer")
    public Customer addCustomer(@RequestBody Customer customer){

            return service.saveCustomer(customer);
    }

    @PostMapping("/addCustomers")
    public List<Customer> addCustomers(@RequestBody List<Customer> customers){

        return service.saveCustomers(customers);
    }

    @GetMapping("/customers")
    public List<Customer> findAllCustomers(){

        return service.getCustomers();
    }

    @GetMapping("/customerById/{id}")
    public Customer findCustomerById(@PathVariable int id){

        return service.getCustomerById(id);
    }

    @GetMapping("/customer/{email}")
    public Customer findCustomerByEmail(@PathVariable String email){

        return service.getCustomerByEmail(email);
    }

    @DeleteMapping ("/customer/delete/{id}")
    public  String deleteCustomer (@PathVariable int id){

        return service.deleteCustomer(id);
    }

}
