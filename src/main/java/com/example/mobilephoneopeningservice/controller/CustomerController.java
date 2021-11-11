package com.example.mobilephoneopeningservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mobilephoneopeningservice.domain.Customer;
import com.example.mobilephoneopeningservice.service.CustomerService;

@RestController
@RequestMapping("customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping
	public Page<Customer> getCustomers(final Pageable pageable){
		return customerService.findAll(pageable);
	}
}
