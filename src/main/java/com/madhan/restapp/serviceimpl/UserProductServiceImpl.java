package com.madhan.restapp.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madhan.restapp.model.UserProduct;
import com.madhan.restapp.repo.UserProductRepo;
import com.madhan.restapp.service.UserProductService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserProductServiceImpl implements UserProductService{

	@Autowired
	UserProductRepo repo;

		public boolean insertProduct(UserProduct product) {
		this.repo.addProduct(product);
		   return true;
	}

	
	public boolean updateProduct(UserProduct product) {
		repo.updateProduct(product);
		return true;
	}

	
	public List<UserProduct> findAllProduct() {
		return this.repo.listAllProduct();
	}

	
	public boolean deleteProduct(Long productId) {
		repo.deleteProduct(productId);
		return true;
	}

	
	public UserProduct findProductyById(Long productId) {
		return repo.findProductById(productId);
	}

}
