package com.madhan.restapp.service;

import java.util.List;

import com.madhan.restapp.model.ProductOrder;

public interface ProductOrderService {

	public boolean insertOrder(ProductOrder order);
	public boolean updateOrder(ProductOrder order);
	public List<ProductOrder> findAllOrder();	
	boolean deleteOrder(Long orderId);
	ProductOrder findOrderById(Long orderId);
}
