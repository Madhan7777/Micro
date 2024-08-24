package com.madhan.restapp.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madhan.restapp.model.AdminProduct;
import com.madhan.restapp.repo.AdminProductRepo;
import com.madhan.restapp.service.AdminProductService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AdminProductServiceImpl implements AdminProductService{

	@Autowired
	AdminProductRepo repo;

		public boolean insertProduct(AdminProduct product) {
		this.repo.addProduct(product);
		   return true;
	}

	
	public boolean updateProduct(AdminProduct product) {
		repo.updateProduct(product);
		return true;
	}

	
	public List<AdminProduct> findAllProduct() {
		return this.repo.listAllProduct();
	}

	
	public boolean deleteProduct(Long productId) {
		repo.deleteProduct(productId);
		return true;
	}

	
	public AdminProduct findProductyById(Long productId) {
		return repo.findProductById(productId);
	}

}
