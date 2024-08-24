package com.madhan.restapp.repoimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.madhan.restapp.model.UserCart;
import com.madhan.restapp.repo.UserCartRepo;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class UserCartRepoImpl implements UserCartRepo {

    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional
    public UserCart save(UserCart userCart) {
        try {
            if (userCart.getId() == null) {
                entityManager.persist(userCart); 
            } else {
                entityManager.merge(userCart); 
            }
            return userCart;
        } catch (Exception e) {
            e.printStackTrace();
            return null; 
        }
    }
    
    

//    @Override
    public UserCart findById(Long id) {
		return null;
//        try {
//            UserCart userCart = entityManager.find(UserCart.class, id);
//            return Optional.ofNullable(userCart);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return Optional.empty(); // Or handle the exception as needed
//        }
    }

    @Override
    public List<UserCart> findAll() {
        try {
            return entityManager.createQuery("from UserCart", UserCart.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null; 
        }
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        try {
            UserCart userCart = entityManager.find(UserCart.class, id);
            if (userCart != null) {
                entityManager.remove(userCart);
            }
        } catch (Exception e) {
            e.printStackTrace();
            
        }
    }
}
