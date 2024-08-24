package com.madhan.restapp.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madhan.restapp.model.Admin;
import com.madhan.restapp.repo.AdminRepo;
import com.madhan.restapp.service.AdminService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminRepo repo;

	
	public boolean addAdmin(Admin admin) {
		repo.addAdmin(admin);
		return true;
	}

	
	public Optional<Admin> findByemail(String email) {
		return this.repo.findByemail(email);
	}

	
	public Optional<Admin> adminLogin(String email, String password) {
		return repo.findByemail(email);
	}

}
