package com.madhan.restapp.repo;

import java.util.List;
import java.util.Optional;

import com.madhan.restapp.model.UserCart;

public interface UserCartRepo {

	UserCart save(UserCart userCart);

	UserCart findById(Long id);

	List<UserCart> findAll();

	void deleteById(Long id);

	
}
