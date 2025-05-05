package com.productapp;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProductappSpringRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductappSpringRestApplication.class, args);
	}

	@Bean
	ModelMapper mapper() {
		return new ModelMapper();
	}
}
