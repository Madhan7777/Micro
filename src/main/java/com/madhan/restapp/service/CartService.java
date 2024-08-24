package com.madhan.restapp.service;

import java.util.List;

import com.madhan.restapp.model.Cart;

public interface CartService {
	
	public boolean validateCart(Cart details);

	boolean deleteCart(Long cartId);

	Cart findCartById(Long cartId);

	List<Cart> findAllCart();
	
	public void insertCart(Cart cart);

}
