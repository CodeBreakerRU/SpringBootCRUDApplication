package com.mtit.abcApplication.Customer.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

@Table(name = "CUSTOMER")

public class Customer {
    @Id
    @GeneratedValue

    private int id;
    private String name;
    private String email;
    private String address;
    private int phone;
}
