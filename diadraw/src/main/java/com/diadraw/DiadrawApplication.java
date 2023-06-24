package com.diadraw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DiadrawApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiadrawApplication.class, args);
	}

}
