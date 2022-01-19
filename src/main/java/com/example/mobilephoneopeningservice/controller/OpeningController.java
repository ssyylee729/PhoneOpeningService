package com.example.mobilephoneopeningservice.controller;

import com.example.mobilephoneopeningservice.dto.OpeningDto;
import com.example.mobilephoneopeningservice.service.OpeningService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/openings")
@Slf4j
public class OpeningController {

    @Autowired
    private OpeningService openingService;

    @PostMapping
    public ResponseEntity<OpeningDto> insertNewOpening(@RequestBody OpeningDto openingDto){
        log.info(openingDto.toString());
        OpeningDto openingDtoResponse = openingService.insertNewOpening(openingDto);
        return ResponseEntity.ok(openingDtoResponse);
    }

}
