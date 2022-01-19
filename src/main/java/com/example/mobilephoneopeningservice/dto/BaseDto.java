package com.example.mobilephoneopeningservice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class BaseDto {
    private LocalDateTime createdDt;

    private LocalDateTime updatedDt;
}