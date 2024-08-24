package com.madhan.restapp.repoimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.madhan.restapp.model.Payment;
import com.madhan.restapp.repo.PaymentRepo;

import jakarta.persistence.EntityManager;

@Repository
public class PaymentRepoImpl implements PaymentRepo {

    @Autowired
    private EntityManager entityManager;

    @Override
    public Payment save(Payment payment) {
        try {
            if (payment.getId() == null) {
                entityManager.persist(payment);
            } else {
                entityManager.merge(payment);
            }
            return payment;
        } catch (Exception e) {
            e.printStackTrace();
            return null; 
        }
    }

    @Override
    public Optional<Payment> findById(Long id) {
        try {
            Payment payment = entityManager.find(Payment.class, id);
            return Optional.ofNullable(payment);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty(); 
        }
    }

    @Override
    public List<Payment> findAll() {
        try {
            return entityManager.createQuery("from Payment", Payment.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null; 
        }
    }

    @Override
    public void deleteById(Long id) {
        try {
            Payment payment = entityManager.find(Payment.class, id);
            if (payment != null) {
                entityManager.remove(payment);
            }
        } catch (Exception e) {
            e.printStackTrace();
           
        }
    }
}
