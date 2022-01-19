package com.example.mobilephoneopeningservice.repository;

import com.example.mobilephoneopeningservice.domain.Opening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OpeningRepository extends JpaRepository<Opening, Long> {


    @Query(value = "select * from Opening where status = 0", nativeQuery = true)
    List<Opening> findByStatusWaiting();
}
