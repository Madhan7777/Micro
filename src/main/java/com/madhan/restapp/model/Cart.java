package com.madhan.restapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Cart_tbl")
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int CartId;
	
	@ManyToOne
	@JoinColumn(name="userId")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="productId")
	private AdminProduct adminProduct;
	
	 @ManyToOne
	    @JoinColumn(name = "orderTrackingId")
	    private OrderTracking orderTracking;
	
	private int totalPrice;
	
	private int quantity;

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cart(int cartId, User user, AdminProduct adminProduct, OrderTracking orderTracking, int totalPrice,
			int quantity) {
		super();
		CartId = cartId;
		this.user = user;
		this.adminProduct = adminProduct;
		this.orderTracking = orderTracking;
		this.totalPrice = totalPrice;
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Cart [CartId=" + CartId + ", user=" + user + ", adminProduct=" + adminProduct + ", orderTracking="
				+ orderTracking + ", totalPrice=" + totalPrice + ", quantity=" + quantity + "]";
	}

	public int getCartId() {
		return CartId;
	}

	public void setCartId(int cartId) {
		CartId = cartId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public AdminProduct getAdminProduct() {
		return adminProduct;
	}

	public void setAdminProduct(AdminProduct adminProduct) {
		this.adminProduct = adminProduct;
	}

	public OrderTracking getOrderTracking() {
		return orderTracking;
	}

	public void setOrderTracking(OrderTracking orderTracking) {
		this.orderTracking = orderTracking;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
	

}
