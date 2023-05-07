package btlSpringMvc.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import btlSpringMvc.dao.IProduct_variant;
import btlSpringMvc.entities.Product_variant;

@Repository
public class Product_variantDaoImpl implements IProduct_variant{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Product_variant> findAll() {
		Session session = sessionFactory.openSession();
		try {
			List<Product_variant> list = session.createQuery("from Product_variant",Product_variant.class).list();
			session.close();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Boolean insert(Product_variant pro_variant) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product_variant> findByAll(Long proDetai_id, int color_id, int size_id) {
		Session session = sessionFactory.openSession();
		try {
			List<Product_variant> list = session.createQuery("from Product_variant where prod_details_id = :proDetai_id and color_id=:color_id and size_id=:size_id")
			.setParameter("proDetai_id", proDetai_id)
			.setParameter("color_id", color_id)
			.setParameter("size_id", size_id).list();
			session.close();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
