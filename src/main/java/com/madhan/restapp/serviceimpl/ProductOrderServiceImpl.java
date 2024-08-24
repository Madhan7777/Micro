package com.madhan.restapp.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madhan.restapp.model.ProductOrder;
import com.madhan.restapp.repo.ProductOrderRepo;
import com.madhan.restapp.service.ProductOrderService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductOrderServiceImpl implements ProductOrderService{

	@Autowired
	ProductOrderRepo repo;

	
	public boolean insertOrder(ProductOrder order) {
		this.repo.addOrder(order);
		   return true;
	}


	public boolean updateOrder(ProductOrder order) {
		repo.updateOrder(order);
		return true;
	}


	public List<ProductOrder> findAllOrder() {
		return this.repo.listAllOrder();	}

	
	public boolean deleteOrder(Long orderId) {
		repo.deleteOrder(orderId);
		return true;
	}


	public ProductOrder findOrderById(Long orderId) {
		return repo.findOrderById(orderId);
	}
}
