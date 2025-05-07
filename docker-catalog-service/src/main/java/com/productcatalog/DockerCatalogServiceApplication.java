package com.productcatalog;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class DockerCatalogServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DockerCatalogServiceApplication.class, args);
	}
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	ModelMapper mapper() {
		return new ModelMapper();
	}

}
