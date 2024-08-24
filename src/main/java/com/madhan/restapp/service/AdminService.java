package com.madhan.restapp.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.madhan.restapp.model.Admin;

@Service
public interface AdminService {
	
	public boolean addAdmin(Admin admin);

	public Optional<Admin> findByemail(String email);

	public Optional<Admin> adminLogin(String email, String password);

}
