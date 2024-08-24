package com.madhan.restapp.repo;

import java.util.List;

import com.madhan.restapp.model.UserProduct;

public interface UserProductRepo {

	public String addProduct(UserProduct product);
	public UserProduct findProductById(Long productId);
	public String updateProduct(UserProduct product);
	public String deleteProduct(Long productId);
	public List<UserProduct> listAllProduct();
}
