package com.madhan.restapp.model;

import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "AdminProduct_table")
public class AdminProduct {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;
	
	@Lob
	@Column(name = "imageproduct",length=1000)
	private byte[] imageProduct;
	
	private String imageName;
	private String imageType;
	
	private String category;
	
	private String productName;
	
	private String description;
	
	private String quantity;
	
	private int price;
	
	@JsonIgnoreProperties("adminProduct")
	@OneToMany(mappedBy = "adminProduct",cascade = CascadeType.ALL)
	private List<ProductOrder> Orders;
	
	@ManyToOne
	@JoinColumn(name="adminId")
	private Admin admin;

	public AdminProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AdminProduct(Long productId, byte[] imageProduct, String imageName, String imageType, String category,
			String productName, String description, String quantity, int price, List<ProductOrder> orders,
			Admin admin) {
		super();
		this.productId = productId;
		this.imageProduct = imageProduct;
		this.imageName = imageName;
		this.imageType = imageType;
		this.category = category;
		this.productName = productName;
		this.description = description;
		this.quantity = quantity;
		this.price = price;
		Orders = orders;
		this.admin = admin;
	}

	@Override
	public String toString() {
		return "AdminProduct [productId=" + productId + ", imageProduct=" + Arrays.toString(imageProduct)
				+ ", imageName=" + imageName + ", imageType=" + imageType + ", category=" + category + ", productName="
				+ productName + ", description=" + description + ", quantity=" + quantity + ", price=" + price
				+ ", Orders=" + Orders + ", admin=" + admin + "]";
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public byte[] getImageProduct() {
		return imageProduct;
	}

	public void setImageProduct(byte[] imageProduct) {
		this.imageProduct = imageProduct;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getImageType() {
		return imageType;
	}

	public void setImageType(String imageType) {
		this.imageType = imageType;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public List<ProductOrder> getOrders() {
		return Orders;
	}

	public void setOrders(List<ProductOrder> orders) {
		Orders = orders;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	
}
