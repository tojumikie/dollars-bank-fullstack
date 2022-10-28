package com.dollarsbank.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
public class DollarsbankSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(DollarsbankSpringApplication.class, args);
	}

}
