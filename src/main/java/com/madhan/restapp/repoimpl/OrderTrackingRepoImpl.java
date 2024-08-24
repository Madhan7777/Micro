package com.madhan.restapp.repoimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.madhan.restapp.model.OrderTracking;
import com.madhan.restapp.repo.OrderTrackingRepo;

import jakarta.persistence.EntityManager;

@Repository
public class OrderTrackingRepoImpl implements OrderTrackingRepo {

    @Autowired
    private EntityManager entityManager;

    @Override
    public OrderTracking save(OrderTracking orderTracking) {
        try {
            if (orderTracking.getId() == null) {
                entityManager.persist(orderTracking);
            } else {
                entityManager.merge(orderTracking);
            }
            return orderTracking;
        } catch (Exception e) {
            e.printStackTrace();
            return null; 
        }
    }

    @Override
    public Optional<OrderTracking> findById(Long id) {
        try {
            OrderTracking orderTracking = entityManager.find(OrderTracking.class, id);
            return Optional.ofNullable(orderTracking);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty(); 
        }
    }

    @Override
    public List<OrderTracking> findAll() {
        try {
            return entityManager.createQuery("from OrderTracking", OrderTracking.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null; 
        }
    }

    @Override
    public void deleteById(Long id) {
        try {
            OrderTracking orderTracking = entityManager.find(OrderTracking.class, id);
            if (orderTracking != null) {
                entityManager.remove(orderTracking);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
