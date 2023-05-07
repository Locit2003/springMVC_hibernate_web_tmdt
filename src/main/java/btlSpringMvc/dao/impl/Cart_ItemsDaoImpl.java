package btlSpringMvc.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import btlSpringMvc.DTO.ProductDetailsDTO;
import btlSpringMvc.dao.ICart_itemDao;
import btlSpringMvc.entities.Cart_items;
import btlSpringMvc.entities.Categories;
import btlSpringMvc.entities.Product_variant;

@Repository
public class Cart_ItemsDaoImpl implements ICart_itemDao{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<Cart_items> findAll() {
		Session session = sessionFactory.openSession();
		try {
			List<Cart_items> cartItem = session.createQuery("from Cat_items",Cart_items.class).getResultList();
			session.close();
			return cartItem;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Boolean save(Cart_items cart_items) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(cart_items);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally {
			session.close();
		}
		return false;
	}

	@Override
	public Boolean findProInCartItem(Long proId, String colorName, String sizeName,int cartId,int quantity) {
		Session session = sessionFactory.openSession();
		try {
			List<Cart_items> list = session.createQuery("from Cart_items where product_details_id = :proDetai_id and colorName=:colorname and sizeName=:sizename and cart_id=:cart_id")
			.setParameter("proDetai_id", proId)
			.setParameter("colorname", colorName)
			.setParameter("sizename", sizeName)
			.setParameter("cart_id", cartId).list();
			session.close();
			return update(list.get(0),quantity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean update(Cart_items cart_items,int quantityNew) {
		int updateQuantity = quantityNew+cart_items.getQuantity();
		cart_items.setQuantity(updateQuantity);
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.update(cart_items);
			session.getTransaction().commit();
			session.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			session.close();
		}
		return false;
	}

	@Override
	public Boolean delete(int id) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.delete(this.findById(id));
			session.getTransaction().commit();
			session.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return false;
	}

	@Override
	public Cart_items findById(int id) {
		Session session = sessionFactory.openSession();
		try {
			Cart_items cart = (Cart_items) session.get(Cart_items.class, id);
			session.close();
			return cart;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null; 
	}

}
