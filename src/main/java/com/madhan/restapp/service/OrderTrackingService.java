package com.madhan.restapp.service;

import com.madhan.restapp.model.OrderTracking;

import java.util.List;
import java.util.Optional;

public interface OrderTrackingService {
    OrderTracking save(OrderTracking orderTracking);
    Optional<OrderTracking> findById(Long id);
    List<OrderTracking> findAll();
    void deleteById(Long id);
}
