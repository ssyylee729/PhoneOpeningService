package com.example.mobilephoneopeningservice.repository;

import com.example.mobilephoneopeningservice.domain.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {
}
