package com.madhan.restapp.serviceimpl;

import com.madhan.restapp.model.Payment;
import com.madhan.restapp.repo.PaymentRepo;
import com.madhan.restapp.service.PaymentService;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepo paymentRepo;

    @Override
    public Payment save(Payment payment) {
        return paymentRepo.save(payment);
    }

    @Override
    public Optional<Payment> findById(Long id) {
        return paymentRepo.findById(id);
    }

    @Override
    public List<Payment> findAll() {
        return paymentRepo.findAll();
    }

    @Override
    public void deleteById(Long id) {
        paymentRepo.deleteById(id);
    }
}
