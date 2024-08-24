package com.madhan.restapp.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madhan.restapp.model.User;
import com.madhan.restapp.repo.UserRepo;
import com.madhan.restapp.service.UserService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepo repo;

	
	public boolean addUser(User user) {
		repo.addUser(user);
		return true;
	}

	
	public Optional<User> findbyemail(String email) {
		return this.repo.findbyemail(email);
	}

	
	public Optional<User> UserLogin(String email, String password) {
		return repo.findbyemail(email);
	}

	
	public List<User> findAllUser() {
		return this.repo.listAllUser();
	}


	@Override
	public User getUserById1(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public User getUserById(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
