package com.madhan.restapp.service;

import com.madhan.restapp.model.Payment;

import java.util.List;
import java.util.Optional;

public interface PaymentService {
    Payment save(Payment payment);
    Optional<Payment> findById(Long id);
    List<Payment> findAll();
    void deleteById(Long id);
}
