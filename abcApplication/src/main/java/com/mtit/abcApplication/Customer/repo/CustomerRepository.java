package com.mtit.abcApplication.Customer.repo;

import com.mtit.abcApplication.Customer.Domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepository extends JpaRepository <Customer, Integer> {

    Customer findByEmail(String email);
}
