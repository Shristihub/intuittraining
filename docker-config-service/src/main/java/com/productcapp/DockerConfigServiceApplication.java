package com.productcapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class DockerConfigServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DockerConfigServiceApplication.class, args);
	}

}
