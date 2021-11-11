package com.example.mobilephoneopeningservice.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;

import com.example.mobilephoneopeningservice.domain.Opening;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
@SpringBootTest
class OpeningRepositoryTest {

    @Autowired
    OpeningRepository openingRepository;

    @Autowired
    OpeningHistoryRepository openingHistoryRepository;
    
    @Autowired
    CustomerRepository customerRepository;

    @Test
    void openingCrud(){
    	openingRepository.findAll().forEach(System.out::println);
    	Opening opening = new Opening();
    	opening.setCustomer(customerRepository.findById(1L).orElse(null));
    	opening.setRequestDt(LocalDateTime.now());
    	opening.setStatus(1);
    	openingRepository.save(opening);
    	
    	openingRepository.findAll().forEach(System.out::println);
    	
    	openingHistoryRepository.findAll().forEach(System.out::println);

    }
}