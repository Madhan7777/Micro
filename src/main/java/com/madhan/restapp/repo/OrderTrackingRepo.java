package com.madhan.restapp.repo;

import java.util.List;
import java.util.Optional;

import com.madhan.restapp.model.OrderTracking;

public interface OrderTrackingRepo {

	OrderTracking save(OrderTracking orderTracking);

	Optional<OrderTracking> findById(Long id);

	List<OrderTracking> findAll();

	void deleteById(Long id);

	




}
