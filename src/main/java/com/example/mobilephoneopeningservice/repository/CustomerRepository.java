package com.example.mobilephoneopeningservice.repository;

import com.example.mobilephoneopeningservice.domain.Customer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	List<Customer> findByName(String name);

	Page<Customer> findAll(Pageable pageable);

	List<Customer> findAll();

	Customer findByCustomerId(String customerId);

	void deleteByCustomerId(String customerId);
}
