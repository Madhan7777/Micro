package com.madhan.restapp.repoimpl;

import java.util.List;

import java.util.Optional;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.madhan.restapp.model.UserProduct;
import com.madhan.restapp.repo.UserProductRepo;

import jakarta.persistence.EntityManager;

import jakarta.transaction.Transactional;

@Repository
public class UserProductRepoImpl implements UserProductRepo {

	@Autowired
	private EntityManager entity;

	@Override
	public String addProduct(UserProduct product) {
		String msg="";
		try {
		entity.persist(product);
		return msg="Inserted Success";
		}catch(Exception e) {
			return msg="Inserted failure";
		}

	}

	@Override
	public UserProduct findProductById(Long productId) {
		Query<UserProduct> qrery = (Query<UserProduct>) entity.createQuery("from UserProduct where productId=:id");
		qrery.setParameter("id", productId);
		return qrery.getSingleResult();
	}

	@Override
	public String updateProduct(UserProduct product) {
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
		UserProduct prod = entity.find(UserProduct.class, productId);
		try {
			entity.remove(prod);
			return msg="deletion success";
		}catch(Exception e) {
			return msg="deletion failure";
		}
	}

	@Override
	public List<UserProduct> listAllProduct() {
		List<UserProduct> UserList =  entity.createQuery("from UserProduct").getResultList();
		return UserList;
	}
}
