package com.productinventory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EcomInventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcomInventoryServiceApplication.class, args);
	}

}
