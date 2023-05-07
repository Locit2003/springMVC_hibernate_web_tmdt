package btlSpringMvc.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import btlSpringMvc.dao.IBiil_Dao;
import btlSpringMvc.entities.Receipts;

@Repository
public class IBill_DaoImpl implements IBiil_Dao{
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public Boolean insert(Receipts bill) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(bill);
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
	public List<Receipts> findByUserId(Long userId) {
		Session session = sessionFactory.openSession();
		try {
			List<Receipts> cats = session.createQuery("from Receipts where user_id=:userId",Receipts.class).setParameter("userId", userId).list();
			return cats;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Receipts> findAllBill() {
		Session session = sessionFactory.openSession();
		try {
			List<Receipts> bills = session.createQuery("from Receipts",Receipts.class).list();
			return bills;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
