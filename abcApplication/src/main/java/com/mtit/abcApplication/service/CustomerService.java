package com.mtit.abcApplication.service;

import com.mtit.abcApplication.Customer.Domain.Customer;
import com.mtit.abcApplication.Customer.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository repository;

    public Customer saveCustomer(Customer customer){

        return repository.save(customer);
    }
    public List<Customer> saveCustomers(List<Customer> customers){

        return repository.saveAll(customers);
    }
    public List<Customer> getCustomers(){

        return  repository.findAll();
    }
    public Customer getCustomerById(int id){

        return repository.findById(id).orElse(null);
    }
    public Customer getCustomerByEmail (String email){

        return repository.findByEmail(email);
    }
    public String deleteCustomer (int id){

        repository.deleteById(id);
        return "Customer Deleted !! " +id;
    }


}
