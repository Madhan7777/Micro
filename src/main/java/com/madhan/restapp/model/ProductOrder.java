package com.madhan.restapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ProductOrder_table")
public class ProductOrder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderId;
	
	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "productId")
	private AdminProduct adminProduct;
	
	@Column(name = "order_date")
	private String orderDate;
	
	private String userName;
	private String plotNumber;
	private String streetName;
	private String cityName;
	private String stateName;
	private String email;
	private Long contactNumber;
	
	private Long cardNum;
	private int exp;
	private int cvv;
	public ProductOrder() {
		super();
	}
	public ProductOrder(Long orderId, User user, AdminProduct adminProduct, String orderDate, String userName,
			String plotNumber, String streetName, String cityName, String stateName, String email, Long contactNumber,
			Long cardNum, int exp, int cvv) {
		super();
		this.orderId = orderId;
		this.user = user;
		this.adminProduct = adminProduct;
		this.orderDate = orderDate;
		this.userName = userName;
		this.plotNumber = plotNumber;
		this.streetName = streetName;
		this.cityName = cityName;
		this.stateName = stateName;
		this.email = email;
		this.contactNumber = contactNumber;
		this.cardNum = cardNum;
		this.exp = exp;
		this.cvv = cvv;
	}
	@Override
	public String toString() {
		return "ProductOrder [orderId=" + orderId + ", user=" + user + ", adminProduct=" + adminProduct + ", orderDate="
				+ orderDate + ", userName=" + userName + ", plotNumber=" + plotNumber + ", streetName=" + streetName
				+ ", cityName=" + cityName + ", stateName=" + stateName + ", email=" + email + ", contactNumber="
				+ contactNumber + ", cardNum=" + cardNum + ", exp=" + exp + ", cvv=" + cvv + "]";
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
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
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPlotNumber() {
		return plotNumber;
	}
	public void setPlotNumber(String plotNumber) {
		this.plotNumber = plotNumber;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}
	public Long getCardNum() {
		return cardNum;
	}
	public void setCardNum(Long cardNum) {
		this.cardNum = cardNum;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	public int getCvv() {
		return cvv;
	}
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
	
	
	

}
