package com.madhan.restapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "orderId")
    private ProductOrder order;

    private double amount;
    private String paymentMethod; // e.g., Credit Card, PayPal
    private String paymentStatus; // e.g., Completed, Pending
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Payment(Long id, ProductOrder order, double amount, String paymentMethod, String paymentStatus) {
		super();
		this.id = id;
		this.order = order;
		this.amount = amount;
		this.paymentMethod = paymentMethod;
		this.paymentStatus = paymentStatus;
	}
	@Override
	public String toString() {
		return "Payment [id=" + id + ", order=" + order + ", amount=" + amount + ", paymentMethod=" + paymentMethod
				+ ", paymentStatus=" + paymentStatus + "]";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public ProductOrder getOrder() {
		return order;
	}
	public void setOrder(ProductOrder order) {
		this.order = order;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

    
}
