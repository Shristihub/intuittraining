package com.productcart.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Cart {

	private int cartId;
	private List<CartItem> cartItems;
	private double totalAmount;
}
