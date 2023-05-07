package btlSpringMvc.entities;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "Account")
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private Long id;
	
	@Column(name = "Username")
	@NotEmpty(message = "User Name is not empty!")
	private String userName;
	
	@Column(name = "Email")
	@NotEmpty(message = "Email is not empty!")
	@Email(message = "Email should be valid")
	private String email;
	
	@Column(name = "Phone")
	@NotEmpty(message = "Phone is not empty!")
	private String phone;
	
	@Column(name = "Password")
	@NotEmpty(message = "Password is not empty!")
	private String password;
	
	@Column(name = "Fullname")
	@NotEmpty(message = "fullName is not empty!")
	private String fullName;
	
	@Column(name = "Enabled")
	private Boolean enabled;
	
	@OneToMany(mappedBy = "ac", fetch = FetchType.EAGER)
	private Set<Account_roles> acRoles;
	
	@OneToMany(mappedBy = "account",fetch = FetchType.EAGER)
	private List<Cart> cart;
	
	@OneToMany(mappedBy = "account")
	private List<Receipts> bill;
	
	public Account() {
		// TODO Auto-generated constructor stub
	}


	public Account(Long id, @NotEmpty(message = "User Name is not empty!") String userName,
			@NotEmpty(message = "Email is not empty!") @Email(message = "Email should be valid") String email,
			@NotEmpty(message = "Phone is not empty!") String phone,
			@NotEmpty(message = "Password is not empty!") String password,
			@NotEmpty(message = "fullName is not empty!") String fullName, Boolean enabled, Set<Account_roles> acRoles,
			List<Cart> cart, List<Receipts> bill) {
		super();
		this.id = id;
		this.userName = userName;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.fullName = fullName;
		this.enabled = enabled;
		this.acRoles = acRoles;
		this.cart = cart;
		this.bill = bill;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Set<Account_roles> getAcRoles() {
		return acRoles;
	}

	public void setAcRoles(Set<Account_roles> acRoles) {
		this.acRoles = acRoles;
	}


	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public List<Cart> getCart() {
		return cart;
	}

	public void setCart(List<Cart> cart) {
		this.cart = cart;
	}


	public List<Receipts> getBill() {
		return bill;
	}


	public void setBill(List<Receipts> bill) {
		this.bill = bill;
	}
	
}
