package com.productcart.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.productcart.model.Cart;
import com.productcart.model.CartItem;
import com.productcart.model.Product;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements ICartService{
	
	// get the url of the inventory service
    private final String BASEURL = "http://product-info/info-service/v1/productinfo";
	
	private final RestTemplate restTemplate;
	private Cart cart = new Cart();
	private List<CartItem> cartItems = new ArrayList<>();
	private double totalAmount = 0;
	
	
	@Override
	@CircuitBreaker(name = "cart-service", fallbackMethod = "fallbackAddToCart")
	public String addItemToCart(int productId) {
		
		String url = BASEURL.concat("/productId/")+productId;
		// get product from info service
		ResponseEntity<Product> entity = (ResponseEntity)restTemplate.getForEntity(url,Product.class);
		Product product = entity.getBody();
		CartItem item = new CartItem(1,product.getProductId(),product.getProductName(),product.getPrice());
		cartItems.add(item);
		cart.setCartId(10);
		cart.setCartItems(cartItems);
		//add item to cartItems list
//		cart.getCartItems().add(item);
		totalAmount = cartItems.stream()
		         .mapToDouble(cartItem->cartItem.getPrice())
		         .sum();
		cart.setTotalAmount(totalAmount);
		return "Item added";
	}

	@Override
	public Cart viewCart() {
		return cart;
	}

	@Override
	public void deleteItemFromCart(int productId) {
		// TODO Auto-generated method stub
		
	}
	
	//fallback method - same signature as the original method
	public String fallbackAddToCart(int productId, Exception e) {
		return "error occured.. try again";
	}
	

}
