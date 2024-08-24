package com.madhan.restapp.serviceimpl;

import com.madhan.restapp.model.CartItem;
import com.madhan.restapp.model.UserCart;
import com.madhan.restapp.repo.UserCartRepo;
import com.madhan.restapp.service.UserCartService;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserCartServiceImpl implements UserCartService {

    @Autowired
    private UserCartRepo userCartRepository;

    @Override
    public UserCart saveUserCart(UserCart userCart) {
        return userCartRepository.save(userCart);
    }

//    @Override
//    public UserCart getUserCartById(Long id) {
//        return userCartRepository.findById(id);
//    }
    
    public UserCart findById(Long id) {
        return userCartRepository.findById(id); // Use findById and handle null manually
    }

    @Override
    public List<UserCart> getAllUserCarts() {
        return userCartRepository.findAll();
    }

    @Override
    public void deleteUserCart(Long id) {
        userCartRepository.deleteById(id);
    }

	@Override
	public UserCart getUserCartById(Long id) {
		// TODO Auto-generated method stub
		return userCartRepository.findById(id);
	}

	@Override
	public UserCart addItemToCart(Long cartId, CartItem newItem) {
		// TODO Auto-generated method stub
		return null;
	}
}
