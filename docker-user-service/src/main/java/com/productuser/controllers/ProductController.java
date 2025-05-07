package com.productuser.controllers;


import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product-api/v1")
public class ProductController {
	
	
	 @GetMapping("/user/products")
	 ResponseEntity<List<String>> showProducts(){
		return ResponseEntity.ok(Arrays.asList("Mobile","Airpods","Headphones"));
	}
	 
	 @GetMapping("/admin/products")
	 ResponseEntity<String> addProduct(){
		return ResponseEntity.ok("Product Added");
	}
	 
	 
	 
	 
	 
}
