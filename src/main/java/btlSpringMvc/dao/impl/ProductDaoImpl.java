package btlSpringMvc.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import btlSpringMvc.dao.IProductDao;
import btlSpringMvc.entities.Product;
import btlSpringMvc.entities.ProductDetails;

@Repository
public class ProductDaoImpl implements IProductDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<ProductDetails> findAll() {
		Session session = sessionFactory.openSession();
		try {
			List<ProductDetails> list = session.createQuery("from ProductDetails",ProductDetails.class).list();
			session.close();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean insert(Product p) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(p);
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
	public boolean update(Product p) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.update(p);
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
	public boolean delete(Long proId) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.delete(this.findByIdOfProductDetails(proId));
			session.delete(this.findByIdOfproduct(this.findByIdOfProductDetails(proId).getProduct().getProId()));
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
	public ProductDetails findByIdOfProductDetails(Long id) {
		Session session = sessionFactory.openSession();
		try {
			ProductDetails prodById = session.get(ProductDetails.class,id);
			session.close();
			return prodById;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Product getCategoryById(int proId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> findAllCatId(int catId) {
		Session session = sessionFactory.openSession();
		try {
			List<Product> list = session.createQuery("from Product where catId=:catId",Product.class).setParameter("catId", catId).list();
			session.close();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean insert(ProductDetails p) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(p);
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
	public Product findByIdOfproduct(int id) {
		Session session = sessionFactory.openSession();
		try {
			Product prodById = session.get(Product.class,id);
			session.close();
			return prodById;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
