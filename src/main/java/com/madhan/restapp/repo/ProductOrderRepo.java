package com.madhan.restapp.repo;

import java.util.List;

import com.madhan.restapp.model.ProductOrder;

public interface ProductOrderRepo {

	public String addOrder(ProductOrder order);
	public ProductOrder findOrderById(Long orderId);
	public String updateOrder(ProductOrder order);
	public String deleteOrder(Long productId);
	public List<ProductOrder> listAllOrder();
	
	
}
