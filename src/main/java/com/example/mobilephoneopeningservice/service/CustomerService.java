package com.example.mobilephoneopeningservice.service;

import com.example.mobilephoneopeningservice.dto.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.mobilephoneopeningservice.domain.Customer;
import com.example.mobilephoneopeningservice.repository.CustomerRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;

	public List<CustomerDto> getCustomerDtoList(){
		List<Customer> customers = customerRepository.findAll();
		List<CustomerDto> customerDtoList = customers.stream().map(CustomerDto::entityToDto).collect(Collectors.toList());
		return customerDtoList;
	}

	public List<CustomerDto> findAllByPage(int pageNo, int pageSize){
		List<Customer> customers = customerRepository.findAll(PageRequest.of(pageNo, pageSize)).toList();
		List<CustomerDto> customerDtoList = customers.stream().map(CustomerDto::entityToDto).collect(Collectors.toList());
		return customerDtoList;
	}

	public CustomerDto insertNewCustomer(CustomerDto customerDto){
		Customer customer = CustomerDto.dtoToEntity(customerDto);
		customer = customerRepository.save(customer);

		return CustomerDto.entityToDto(customer);
	}

	public CustomerDto updateCustomerDetail(CustomerDto customerDto){
		Long id = customerRepository.findByCustomerId(customerDto.getCustomerId()).getId();
		Customer customer = CustomerDto.dtoToEntity(customerDto);
		customer.setId(id);
		customer = customerRepository.save(customer);

		return CustomerDto.entityToDto(customer);
	}

	public void deleteCustomerByCustomerId(String customerId){
		customerRepository.deleteByCustomerId(customerId);
	}

}
