package com.madhan.restapp.service;

import com.madhan.restapp.model.CartItem;
import com.madhan.restapp.model.UserCart;

import java.util.List;
import java.util.Optional;

public interface UserCartService {
    UserCart saveUserCart(UserCart userCart);
    UserCart getUserCartById(Long id);
    List<UserCart> getAllUserCarts();
    void deleteUserCart(Long id);
	UserCart addItemToCart(Long cartId, CartItem newItem);
}
