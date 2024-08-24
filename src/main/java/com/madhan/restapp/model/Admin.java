package com.madhan.restapp.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="admin")
public class Admin {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long adminId;
	private String adminName;
	@Column(unique = true)
	private String email;
	private String phoneno;
	private String password;
	
	@OneToMany(mappedBy = "admin")
	private List<AdminProduct>adminProduct;

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(Long adminId, String adminName, String email, String phoneno, String password,
			List<AdminProduct> adminProduct) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.email = email;
		this.phoneno = phoneno;
		this.password = password;
		this.adminProduct = adminProduct;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminName=" + adminName + ", email=" + email + ", phoneno=" + phoneno
				+ ", password=" + password + ", adminProduct=" + adminProduct + "]";
	}

	public Long getAdminId() {
		return adminId;
	}

	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<AdminProduct> getAdminProduct() {
		return adminProduct;
	}

	public void setAdminProduct(List<AdminProduct> adminProduct) {
		this.adminProduct = adminProduct;
	}
	
	
	
	
	
	
    
    

}
