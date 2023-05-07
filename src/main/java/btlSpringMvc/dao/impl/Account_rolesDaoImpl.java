package btlSpringMvc.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import btlSpringMvc.dao.GeneralDAO;
import btlSpringMvc.entities.Account_roles;

@Repository
public class Account_rolesDaoImpl implements GeneralDAO<Account_roles> {

	@Autowired
	
	
	@Override
	public List<Account_roles> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account_roles findByName(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(Account_roles op) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
