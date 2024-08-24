package com.madhan.restapp.repoimpl;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.madhan.restapp.model.ProductOrder;
import com.madhan.restapp.repo.ProductOrderRepo;

import jakarta.persistence.EntityManager;


@Repository
public class ProductOrderRepoImpl implements ProductOrderRepo{
	@Autowired
	private EntityManager entity;

	@Override
	public String addOrder(ProductOrder order) {
		String msg="";
		try {
		entity.persist(order);
		return msg="Inserted Success";
		}catch(Exception e) {
			return msg="Inserted failure";
		}
	}

	@Override
	public ProductOrder findOrderById(Long orderId) {
		Query<ProductOrder> qrery = (Query<ProductOrder>) entity.createQuery("from ProductOrder where orderId=:id");
		qrery.setParameter("id", orderId);
		return qrery.getSingleResult();
	}

	@Override
	public String updateOrder(ProductOrder order) {
		String msg="";
		try {
			entity.merge(order);
			return msg="updation successfull";
		}catch(Exception e) {
			return msg="updation failure";
		}
	}

	@Override
	public String deleteOrder(Long productId) {
		String msg="";
		ProductOrder order = entity.find(ProductOrder.class, productId);
		try {
			entity.remove(order);
			return msg="deletion success";
		}catch(Exception e) {
			return msg="deletion failure";
		}
	}

	@Override
	public List<ProductOrder> listAllOrder() {
		List<ProductOrder> orderList =  entity.createQuery("from ProductOrder").getResultList();
		return orderList;	}

	
}
