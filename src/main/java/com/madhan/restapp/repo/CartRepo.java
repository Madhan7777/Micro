package com.madhan.restapp.repo;

import java.util.List;

import com.madhan.restapp.model.Cart;


public interface CartRepo {
	public boolean validateCart(Cart cart);
	public Cart findCartById(Long cartId);
	public String updateCart(Cart cart);
	public String deleteOrder(Long cartId);
	public List<Cart> listAllCart();
	public void insertCart(Cart cart);

}
