package com.productcart.service;

import com.productcart.model.Cart;

public interface ICartService {

	String addItemToCart(int productId);
	Cart viewCart();
	void deleteItemFromCart(int productId);
}
