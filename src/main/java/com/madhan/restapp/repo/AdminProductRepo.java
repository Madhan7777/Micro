package com.madhan.restapp.repo;

import java.util.List;

import com.madhan.restapp.model.AdminProduct;

public interface AdminProductRepo {

	public String addProduct(AdminProduct product);
	public AdminProduct findProductById(Long productId);
	public String updateProduct(AdminProduct product);
	public String deleteProduct(Long productId);
	public List<AdminProduct> listAllProduct();
}
