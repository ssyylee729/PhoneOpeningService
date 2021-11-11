package com.example.mobilephoneopeningservice.repository;

import com.example.mobilephoneopeningservice.domain.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    void customerCrud(){
        customerRepository.findAll().forEach(System.out::println);
    }
}