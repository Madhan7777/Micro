package com.madhan.restapp.service;

import java.util.List;
import java.util.Optional;

import com.madhan.restapp.model.User;

public interface UserService {

	public boolean addUser(User user);

	public Optional<User> findbyemail(String email);

	public Optional<User> UserLogin(String email, String password);
	
	List<User> findAllUser();

	public User getUserById1(Long userId);

	public User getUserById(Long userId);
}
