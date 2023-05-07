package btlSpringMvc.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import btlSpringMvc.dao.ICartDao;
import btlSpringMvc.entities.Cart;
import btlSpringMvc.entities.Cart_items;

@Repository
public class CartDaoIpml implements ICartDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Cart> findAll() {
		Session session = sessionFactory.openSession();
		try {
			List<Cart> list = session.createQuery("from Cart",Cart.class).list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return null;
	}

	@Override
	public Boolean save(Cart c) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(c);
			session.getTransaction().commit();
			session.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return false;
	}

	@Override
	public Cart findCartOfMe(Long userId) {
		Session session = sessionFactory.openSession();
		try {
			List<Cart> cart = session.createQuery("from Cart where user_id=:user_id")
					.setParameter("user_id", userId).list();
			session.close();
			return (Cart) cart.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Boolean update(Cart c) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.update(c);
			session.getTransaction().commit();
			session.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return false;
	}

}
