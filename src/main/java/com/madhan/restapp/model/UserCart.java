package com.madhan.restapp.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "usercart")
public class UserCart {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @OneToOne
	    @JoinColumn(name = "userId")
	    private User user;

	    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
	    private List<CartItem> cartItems;

	    private double totalAmount;

		public UserCart() {
			super();
			// TODO Auto-generated constructor stub
		}

		public UserCart(Long id, User user, List<CartItem> cartItems, double totalAmount) {
			super();
			this.id = id;
			this.user = user;
			this.cartItems = cartItems;
			this.totalAmount = totalAmount;
		}

		@Override
		public String toString() {
			return "UserCart [id=" + id + ", user=" + user + ", cartItems=" + cartItems + ", totalAmount=" + totalAmount
					+ "]";
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public List<CartItem> getCartItems() {
			return cartItems;
		}

		public void setCartItems(List<CartItem> cartItems) {
			this.cartItems = cartItems;
		}

		public double getTotalAmount() {
			return totalAmount;
		}

		public void setTotalAmount(double totalAmount) {
			this.totalAmount = totalAmount;
		}

		
	    
	    
}
