package btlSpringMvc.service;

import java.util.List;

import btlSpringMvc.entities.Account;
import btlSpringMvc.entities.Account_roles;

public interface IUserService {
	public List<Account> findAll();
	public Account findById(Long id);
	public Boolean save(Account acc);
	public Boolean save(Account_roles accRole);
}
