package com.productcatalog.service;

import java.util.List;

import com.productcatalog.model.ProductDTO;

public interface IProductService {

	void addProduct(ProductDTO productDTO);
	void updateProduct(ProductDTO productDTO);
	void deleteProduct(int productId);
	ProductDTO getById(int productId);
	
	List<ProductDTO> getAllProducts();
	List<ProductDTO> getByCategoryLessPrice(String category,double price);
	List<ProductDTO> getByBrand(String brand);
	List<ProductDTO> getByProductNamePrice(String name, double price);
	
}
