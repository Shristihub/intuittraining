package com.productinfo.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.productinfo.model.Product;


@FeignClient(name = "product-catalog")
public interface IProductCatalogClient {

//	http://localhost:8082/catalog-service/v1/products
	@GetMapping("/catalog-service/v1/products")
	List<Product> getAllProducts();
	
	@GetMapping("/catalog-service/v1/products/brand/{brand}")
	List<Product>  getByBrand(@PathVariable String brand);
	
	@GetMapping("/catalog-service/v1/products/category/{category}/price/{price}")
	List<Product> getByCategoryLessPrice(@PathVariable String category,@PathVariable double price);
	
	@GetMapping("/catalog-service/v1/products/productId/{productId}")
	Product getById(@PathVariable int productId);
}
