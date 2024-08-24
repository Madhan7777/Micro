package com.madhan.restapp.service;

import java.util.List;

import com.madhan.restapp.model.AdminProduct;

public interface AdminProductService {
public boolean insertProduct(AdminProduct product);
	
	public boolean updateProduct(AdminProduct product);
	public List<AdminProduct> findAllProduct();
	
	boolean deleteProduct(Long productId);
	public AdminProduct findProductyById(Long productId);

}


