package btlSpringMvc.entities;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cart")
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartId;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private Account account;
	
	@OneToMany(mappedBy = "cart",fetch = FetchType.EAGER)
	private Set<Cart_items> cart_items;
	
	private float totalPrice; 
	
	private String address;
	
	private String phoneNumber;
	
	private Boolean status;
	
	private Date orderDate;
	
	public Cart() {
		
	}

	public Cart( Account account, Set<Cart_items> cart_items, float totalPrice, String address,
			String phoneNumber, Boolean status, Date orderDate) {
		super();
		this.account = account;
		this.cart_items = cart_items;
		this.totalPrice = totalPrice;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.status = status;
		this.orderDate = orderDate;
	}
	
	public Cart(int cartId, Account account, Set<Cart_items> cart_items, float totalPrice, String address,
			String phoneNumber, Boolean status, Date orderDate) {
		super();
		this.cartId = cartId;
		this.account = account;
		this.cart_items = cart_items;
		this.totalPrice = totalPrice;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.status = status;
		this.orderDate = orderDate;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Set<Cart_items> getCart_items() {
		return cart_items;
	}

	public void setCart_items(Set<Cart_items> cart_items) {
		this.cart_items = cart_items;
	}
	
}
