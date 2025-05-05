package com.productcatalog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductDTO {

	private String productName;
	private Integer productId;
	private String brand;
	private double price;
	private String category;
	private int stock;
	
	
}
