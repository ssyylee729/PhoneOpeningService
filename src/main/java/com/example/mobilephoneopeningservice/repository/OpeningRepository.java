package com.example.mobilephoneopeningservice.repository;

import com.example.mobilephoneopeningservice.domain.Opening;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OpeningRepository extends JpaRepository<Opening, Long> {
}
