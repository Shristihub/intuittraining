package com.productinfo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.productinfo.feign.IProductCatalogClient;
import com.productinfo.model.Product;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductInfoFeignServiceImpl implements IProductInfoService{
	
	private final IProductCatalogClient catalogClient;
	
	@Override
	public List<Product> getAllProducts() {
		return catalogClient.getAllProducts();
	}

	@Override
	public List<Product> getByCategoryLessPrice(String category, double price) {
		return catalogClient.getByCategoryLessPrice(category, price);
	}

	@Override
	public List<Product> getByBrand(String brand) {
		return catalogClient.getByBrand(brand);
	}

	@Override
	public Product getById(int productId) {
		return catalogClient.getById(productId);
	}

	
}
