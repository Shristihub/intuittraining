package com.productinfo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {

	private String productName;
	private Integer productId;
	private String brand;
	private double price;
	private String category;
	
}