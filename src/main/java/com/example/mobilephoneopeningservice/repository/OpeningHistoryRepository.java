package com.example.mobilephoneopeningservice.repository;

import com.example.mobilephoneopeningservice.domain.OpeningHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OpeningHistoryRepository extends JpaRepository<OpeningHistory, Long> {
}
