package btlSpringMvc.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import btlSpringMvc.dao.IImagesDao;
import btlSpringMvc.entities.Images;
import btlSpringMvc.entities.Product_variant;

@Repository
public class ImageDaoImpl implements IImagesDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Images> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Images> findAllByName(String nameImage) {
		Session session = sessionFactory.openSession();
		try {
			List<Images> list = session.createQuery("from Images where imgName=:imgname")
			.setParameter("imgname", nameImage).list();
			session.close();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Boolean save(Images images) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(images);
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
	public Boolean update(Images images) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.update(images);
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
	
}
