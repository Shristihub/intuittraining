package com.greetapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {
	
	@GetMapping("/greet")
	public String greet() {
		return "welcome to docker";
	}

}
