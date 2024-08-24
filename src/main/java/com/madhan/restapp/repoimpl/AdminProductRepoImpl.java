package com.madhan.restapp.repoimpl;

import java.util.List;

import java.util.Optional;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.madhan.restapp.model.AdminProduct;
import com.madhan.restapp.repo.AdminProductRepo;

import jakarta.persistence.EntityManager;

import jakarta.transaction.Transactional;

@Repository
public class AdminProductRepoImpl implements AdminProductRepo {

	@Autowired
	private EntityManager entity;

	@Override
	public String addProduct(AdminProduct product) {
		String msg="";
		try {
		entity.persist(product);
		return msg="Inserted Success";
		}catch(Exception e) {
			return msg="Inserted failure";
		}

	}

	@Override
	public AdminProduct findProductById(Long productId) {
		Query<AdminProduct> qrery = (Query<AdminProduct>) entity.createQuery("from AdminProduct where productId=:id");
		qrery.setParameter("id", productId);
		return qrery.getSingleResult();
	}

	@Override
	public String updateProduct(AdminProduct product) {
		String msg="";
		try {
			entity.merge(product);
			return msg="updation successfull";
		}catch(Exception e) {
			return msg="updation failure";
		}
	}

	@Override
	public String deleteProduct(Long productId) {
		String msg="";
		AdminProduct prod = entity.find(AdminProduct.class, productId);
		try {
			entity.remove(prod);
			return msg="deletion success";
		}catch(Exception e) {
			return msg="deletion failure";
		}
	}

	@Override
	public List<AdminProduct> listAllProduct() {
		List<AdminProduct> UserList =  entity.createQuery("from AdminProduct").getResultList();
		return UserList;
	}
}
