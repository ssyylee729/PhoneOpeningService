package com.example.mobilephoneopeningservice.controller;

import com.example.mobilephoneopeningservice.dto.CustomerDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.mobilephoneopeningservice.domain.Customer;
import com.example.mobilephoneopeningservice.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@Slf4j
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping
	public ResponseEntity<CustomerDto> insertNewCustomer(@RequestBody CustomerDto customerDto) {
		CustomerDto response = customerService.insertNewCustomer(customerDto);

		return  ResponseEntity.ok(response);
	}

	@PutMapping
	public ResponseEntity<CustomerDto> updateCustomerDetail(@RequestBody CustomerDto customerDto) {
		CustomerDto response = customerService.updateCustomerDetail(customerDto);

		return  ResponseEntity.ok(response);
	}

	@DeleteMapping("/{customerId}")
	public ResponseEntity deleteCustomerByCustomerId(@PathVariable String customerId) {
		customerService.deleteCustomerByCustomerId(customerId);

		return ResponseEntity.ok().build();
	}

	@GetMapping("/list")
	public ResponseEntity<List<CustomerDto>> getCustomerList(@RequestParam int pageNo, @RequestParam int pageSize){
		List<CustomerDto> customers = customerService.findAllByPage(pageNo, pageSize);
		return ResponseEntity.ok(customers);
	}

}
