package btlSpringMvc.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import btlSpringMvc.dao.IUserDao;
import btlSpringMvc.entities.Account;
import btlSpringMvc.entities.Account_roles;

@Repository
public class UserDaoImpl implements IUserDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Account> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account findById(Long id) {
		Session session = sessionFactory.openSession();
		try {
			Account acc = session.get(Account.class, id);
			session.close();
			return acc;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Boolean save(Account acc) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(acc);
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
	public Boolean save(Account_roles accRole) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(accRole);
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
