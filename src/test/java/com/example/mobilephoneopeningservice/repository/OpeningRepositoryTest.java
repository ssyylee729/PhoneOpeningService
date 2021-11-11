package com.example.mobilephoneopeningservice.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class OpeningRepositoryTest {

    @Autowired
    OpeningRepository openingRepository;

    @Autowired
    OpeningHistoryRepository openingHistoryRepository;

    @Test
    void openingCrud(){

    }
}