package com.madhan.restapp.service;

import java.util.List;

import com.madhan.restapp.model.UserProduct;

public interface UserProductService {
public boolean insertProduct(UserProduct product);
	
	public boolean updateProduct(UserProduct product);
	public List<UserProduct> findAllProduct();
	
	boolean deleteProduct(Long productId);
	public UserProduct findProductyById(Long productId);

}


