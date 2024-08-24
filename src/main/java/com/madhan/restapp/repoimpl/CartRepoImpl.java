package com.madhan.restapp.repoimpl;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.madhan.restapp.model.AdminProduct;
import com.madhan.restapp.model.Cart;
import com.madhan.restapp.repo.CartRepo;

import jakarta.persistence.EntityManager;

@Repository
public class CartRepoImpl implements CartRepo {
	
	@Autowired
	private EntityManager entity;

	@Override
	public boolean validateCart(Cart cart) {
		try {
			AdminProduct adminProduct = cart.getAdminProduct();
			long prodId = adminProduct.getProductId();
			Query<Cart> query = (Query<Cart>) entity.createQuery("FROM Cart as cart where cart.sellerProduct.productId=:id");
			query.setParameter("id", prodId);
			Cart cart1 = query.getSingleResult();
			return true;
			
			}catch (Exception e) {
				return false;
			}

}
	

	@Override
	public Cart findCartById(Long cartId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateCart(Cart cart) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteOrder(Long cartId) {
		String msg = "";
		Cart cart = entity.find(Cart.class, cartId);
		try {
			entity.remove(cart);
			return msg = "deletion success";
		} catch (Exception e) {
			return msg = "deletion failure";
		}
	}

	@Override
	public List<Cart> listAllCart() {
		List<Cart> cartList = entity.createQuery("from Cart").getResultList();
		return cartList;

	}

	@Override
	public void insertCart(Cart cart) {
		System.err.println(cart);
		try {
			entity.persist(cart);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}


}
