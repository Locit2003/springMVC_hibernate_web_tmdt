package btlSpringMvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import btlSpringMvc.dao.IUserDao;
import btlSpringMvc.entities.Account;
import btlSpringMvc.entities.Account_roles;
import btlSpringMvc.service.IUserService;

@Service
public class UserServiceImpl implements IUserService{
	
	@Autowired
	private IUserDao userDao;

	@Override
	public List<Account> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account findById(Long id) {
		return userDao.findById(id);
	}

	@Override
	public Boolean save(Account acc) {
		return userDao.save(acc);
	}

	@Override
	public Boolean save(Account_roles accRole) {
		return userDao.save(accRole);
	}

}
