package com.productinfo.service;

import java.util.List;

import com.productinfo.model.Product;

public interface IProductInfoService {

	List<Product> getAllProducts();
	List<Product> getByCategoryLessPrice(String category,double price);
	List<Product> getByBrand(String brand);
	Product getById(int productId);
	
}
