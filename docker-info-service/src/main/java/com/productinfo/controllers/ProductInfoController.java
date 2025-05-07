package com.productinfo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.productinfo.model.Product;
import com.productinfo.service.IProductInfoService;

@RestController
@RequestMapping("/info-service/v1")
public class ProductInfoController {
	@Autowired
	@Qualifier(value = "productInfoFeignServiceImpl")
	private IProductInfoService infoService;
	
	@GetMapping("/productinfo")
	ResponseEntity<List<Product>> getAllProducts(){
		List<Product> products = infoService.getAllProducts();
		return ResponseEntity.ok(products);
	}
	
	@GetMapping("/productinfo/catprice")
	ResponseEntity<List<Product>> getByCategoryLessPrice(@RequestParam String category,@RequestParam double price){
		List<Product> products = infoService.getByCategoryLessPrice(category, price);
		return ResponseEntity.ok(products);
		
	}
//	http://localhost:8084/info-service/v1/productinfo/brand/Samsung
	@GetMapping("/productinfo/brand/{brand}")
	ResponseEntity<List<Product>> getByBrand(@PathVariable String brand){
		List<Product> products = infoService.getByBrand(brand);
		return ResponseEntity.ok(products);
	}
	
//	http://localhost:8084/info-service/v1/productinfo/productId/51
	@GetMapping("/productinfo/productId/{productId}")
	ResponseEntity<Product> getById(@PathVariable int productId) {
		Product product = infoService.getById(productId);
		return ResponseEntity.ok(product);
	}
	
	

}
