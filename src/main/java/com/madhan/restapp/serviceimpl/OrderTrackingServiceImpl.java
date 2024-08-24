package com.madhan.restapp.serviceimpl;

import com.madhan.restapp.model.OrderTracking;
import com.madhan.restapp.repo.OrderTrackingRepo;
import com.madhan.restapp.service.OrderTrackingService;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderTrackingServiceImpl implements OrderTrackingService {

    @Autowired
    private OrderTrackingRepo orderTrackingRepo;

    @Override
    public OrderTracking save(OrderTracking orderTracking) {
        return orderTrackingRepo.save(orderTracking);
    }

    @Override
    public Optional<OrderTracking> findById(Long id) {
        return orderTrackingRepo.findById(id);
    }

    @Override
    public List<OrderTracking> findAll() {
        return orderTrackingRepo.findAll();
    }

    @Override
    public void deleteById(Long id) {
        orderTrackingRepo.deleteById(id);
    }
}
