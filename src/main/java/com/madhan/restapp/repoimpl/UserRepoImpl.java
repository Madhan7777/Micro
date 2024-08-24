package com.madhan.restapp.repoimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.madhan.restapp.model.User;
import com.madhan.restapp.repo.UserRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
@Service
public class UserRepoImpl implements UserRepo{

private EntityManager entityManager;
	
	

	public UserRepoImpl() {
		super();
		
	}
	
	@Autowired
	public UserRepoImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}



	@Override
	public void addUser(User user) {
		
		 try {
	        	entityManager.persist(user);
	        }catch(Exception e) {
	            e.printStackTrace();
	        }
		
		
		
	}

	@Override
	public Optional<User> findbyemail(String email) {
		
		
		  return entityManager.createQuery("SELECT a FROM User a WHERE a.email = :email", User.class)
		              .setParameter("email", email)
		              .getResultStream()
		              .findFirst();
	}

	@Override
	public User userLogin(String email, String password) {
		Query q = (Query) entityManager.createQuery("from Customer log where log.email =?1 and log.password=?2");
		q.setParameter(1, email);
		q.setParameter(2, password);
		return (User) q.getSingleResult();
	}

	@Override
	public List<User> listAllUser() {
		List<User> userList =  entityManager.createQuery("from User").getResultList();
		return userList;
	}
	
}
