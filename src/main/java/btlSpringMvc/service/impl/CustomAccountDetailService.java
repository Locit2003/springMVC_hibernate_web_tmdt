package btlSpringMvc.service.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import btlSpringMvc.dao.GeneralDAO;
import btlSpringMvc.entities.Account;
import btlSpringMvc.entities.Account_roles;
import btlSpringMvc.entities.CustomAccountDetails;

@Service
public class CustomAccountDetailService implements UserDetailsService {
	@Autowired
	private GeneralDAO<Account> generalDAO;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return loadUser(username);
	}

	private UserDetails loadUser(String username) {
		Account ac = generalDAO.findByName(username);
		if (ac == null) {
			return null;
		}
		Collection<GrantedAuthority> grantedAuthoritySet = new HashSet<>();
		Set<Account_roles> roles = ac.getAcRoles();
		for (Account_roles account_Role : roles) {
			grantedAuthoritySet.add(new SimpleGrantedAuthority(account_Role.getRole().getName()));
		}
		return new CustomAccountDetails(grantedAuthoritySet,ac.getId(), ac.getEmail(), ac.getPassword(), ac.getUserName(),
				ac.getPhone(), ac.getFullName(), ac.getEnabled(),
				true, true, true);
	}
	
	
	
//	public UserDetails insertUserByUsername(Account accout) throws UsernameNotFoundException {
//		return insertUser(accout);
//	}
//	
//	private UserDetails insertUser(Account accout) {
//		String name = accout.getUserName();
//		Account ac = generalDAO.findByName(name);
//		if (ac == null) {
//			return null;
//		}
//		
//		boolean bl = generalDAO.insert(accout);
//		
//		
//		
//		Collection<GrantedAuthority> grantedAuthoritySet = new HashSet<>();
//		
//		Set<Account_roles> roles = ac.setAcRoles(accout);
//		
//		for (Account_roles account_Role : roles) {
//			grantedAuthoritySet.add(new SimpleGrantedAuthority(account_Role.getRole().getName()));
//		}
//		return new CustomAccountDetails(grantedAuthoritySet, ac.getEmail(), ac.getPassword(), ac.getUserName(),
//				ac.getPhone(), ac.getFullName(), ac.getAddress(), ac.getGender(), ac.getBirthday(), ac.getEnabled(),
//				true, true, true);
//	}
}
