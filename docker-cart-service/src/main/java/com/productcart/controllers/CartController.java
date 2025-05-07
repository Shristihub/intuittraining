package com.productcart.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productcart.model.Cart;
import com.productcart.service.ICartService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/cart-service/v1")
@RequiredArgsConstructor
public class CartController {
	
	private final ICartService cartService;
	
	@GetMapping("/cart/add-to-cart/productId/{productId}")
	String addItemToCart(@PathVariable int productId) {
		return cartService.addItemToCart(productId);
		
	}
	@GetMapping("/cart/view-cart")
	Cart viewCart() {
		return cartService.viewCart();
	}
	
	void deleteItemFromCart(int productId) {
		
	}
	
	
	
	

}
