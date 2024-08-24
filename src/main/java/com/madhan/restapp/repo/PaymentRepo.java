package com.madhan.restapp.repo;

import java.util.List;
import java.util.Optional;

import com.madhan.restapp.model.Payment;

public interface PaymentRepo {

	Payment save(Payment payment);

	Optional<Payment> findById(Long id);

	List<Payment> findAll();

	void deleteById(Long id);

}
