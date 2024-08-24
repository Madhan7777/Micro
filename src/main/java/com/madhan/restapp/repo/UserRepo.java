package com.madhan.restapp.repo;

import java.util.List;
import java.util.Optional;

import com.madhan.restapp.model.User;

public interface UserRepo {

	public void addUser(User user);

	public Optional<User> findbyemail(String email);

	public User userLogin(String email, String password);

	public List<User> listAllUser();

}
