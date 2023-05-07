package btlSpringMvc.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import btlSpringMvc.dao.ICategoryDao;
import btlSpringMvc.entities.Categories;

@Repository
public class CategoryDaoImpl implements ICategoryDao{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Categories> findAll() {
		Session session = sessionFactory.openSession();
		try {
			List<Categories> cats = session.createQuery("from Categories",Categories.class).list();
			return cats;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean insert(Categories c) {
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
			session.close();
		}
		return false;
	}

	@Override
	public boolean update(Categories c) {
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
			session.close();
		}
		return false;
	}

	@Override
	public boolean delete(Long catId) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.delete(this.getCategoryById(catId));
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
	public Categories getCategoryById(Long catId) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			Categories cat = (Categories) session.get(Categories.class, catId);
			session.getTransaction().commit();
			session.close();
			return cat;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			session.close();
		}
		return null; 
	}

}
