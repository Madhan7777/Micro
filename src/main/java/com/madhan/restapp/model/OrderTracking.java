package com.madhan.restapp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "order_tracking")
public class OrderTracking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "orderId")
    private ProductOrder order;

    private String status; // e.g., Delivered, Shipped, Out for Delivery, Packaged

	public OrderTracking() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderTracking(Long id, ProductOrder order, String status) {
		super();
		this.id = id;
		this.order = order;
		this.status = status;
	}

	@Override
	public String toString() {
		return "OrderTracking [id=" + id + ", order=" + order + ", status=" + status + "]";
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

    
}
