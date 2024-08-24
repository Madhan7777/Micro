package com.madhan.restapp.repo;

import java.util.Optional;

import com.madhan.restapp.model.Admin;

public interface AdminRepo {

	 public void addAdmin(Admin admin);
		
		public Optional<Admin> findByemail(String email);

		public Admin adminLogin(String email, String password);

}
