package com.example.mobilephoneopeningservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.mobilephoneopeningservice.domain.Customer;
import com.example.mobilephoneopeningservice.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public Page<Customer> findAll(Pageable pageable){
		return customerRepository.findAll(pageable);
	}

}
