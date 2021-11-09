package com.example.mobilephoneopeningservice.repository;

import com.example.mobilephoneopeningservice.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
