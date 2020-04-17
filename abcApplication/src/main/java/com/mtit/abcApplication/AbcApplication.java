package com.mtit.abcApplication;
import com.mtit.abcApplication.Customer.repo.CustomerRepository;
import com.mtit.abcApplication.Product.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class AbcApplication {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CustomerRepository customerRepository;

	public static void main(String[] args) {

		SpringApplication.run(AbcApplication.class, args);
	}

}
