package com.mtit.abcApplication.Product.repo;

import com.mtit.abcApplication.Product.Domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface ProductRepository extends JpaRepository<Product,Integer> {

    Product findByName(String name);
}
