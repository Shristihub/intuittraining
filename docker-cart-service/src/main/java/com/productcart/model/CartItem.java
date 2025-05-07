package com.productcart.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CartItem {

	private int cartItemId;
	private int productId;
	private String productName;
	private double price;
}
