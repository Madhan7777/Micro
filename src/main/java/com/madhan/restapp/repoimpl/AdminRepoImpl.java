package com.madhan.restapp.repoimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.madhan.restapp.model.Admin;
import com.madhan.restapp.repo.AdminRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
@Service
public class AdminRepoImpl implements AdminRepo{
	
private EntityManager entityManager;
	
	public AdminRepoImpl() {
		super();
	}
	
    @Autowired
	public AdminRepoImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}


	@Override
	public void addAdmin(Admin admin) {
		 try {
	        	entityManager.persist(admin);
	        }catch(Exception e) {
	            e.printStackTrace();
	        }
		
	}

	@Override
	public Optional<Admin> findByemail(String email) {
		return entityManager.createQuery("SELECT a FROM Admin a WHERE a.email = :email", Admin.class)
	              .setParameter("email", email)
	              .getResultStream()
	              .findFirst();
	}

	@Override
	public Admin adminLogin(String email, String password) {
		Query q = (Query) entityManager.createQuery("from Admin log where log.email =?1 and log.password=?2");
		q.setParameter(1, email);
		q.setParameter(2, password);
		return (Admin) q.getSingleResult();
	}
}
