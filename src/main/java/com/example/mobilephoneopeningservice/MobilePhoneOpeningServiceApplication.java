package com.example.mobilephoneopeningservice;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class MobilePhoneOpeningServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MobilePhoneOpeningServiceApplication.class, args);
	}

}
