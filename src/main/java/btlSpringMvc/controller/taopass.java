package btlSpringMvc.controller;

import org.mindrot.jbcrypt.BCrypt;

public class taopass {
	
	private String password;
	
	public taopass(String password) {
		String pass = BCrypt.hashpw(password, BCrypt.gensalt(12));
		this.password = pass;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
