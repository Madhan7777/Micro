package com.madhan.restapp.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madhan.restapp.model.Cart;
import com.madhan.restapp.repoimpl.CartRepoImpl;
import com.madhan.restapp.service.CartService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CartServiceImpl implements CartService {
	
	@Autowired
	CartRepoImpl repo;

	@Override
	public boolean validateCart(Cart details) {
		return repo.validateCart(details);
	}


	@Override
	public boolean deleteCart(Long cartId) {
		repo.deleteOrder(cartId);
		return true;
	}

	@Override
	public Cart findCartById(Long cartId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cart> findAllCart() {
		return this.repo.listAllCart();
	}

	@Override
	public void insertCart(Cart cart) {
		repo.insertCart(cart);
		
	}
	
	

}
