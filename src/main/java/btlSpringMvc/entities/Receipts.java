package btlSpringMvc.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name = "bills")
public class Receipts {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String address;
	
	private Date orderDate;
	
	private String phone;
	
	private Boolean status;
	
	private float total_price;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private Account account;
	
	@OneToMany(mappedBy = "bill")
	private List<Cart_items> cart_Items;
	
	public Receipts() {
	}
	

	public Receipts(Long id, String address, Date orderDate, String phone, Boolean status, float total_price,
			Account account) {
		super();
		this.id = id;
		this.address = address;
		this.orderDate = orderDate;
		this.phone = phone;
		this.status = status;
		this.total_price = total_price;
		this.account = account;
	}


	public Receipts(String address, Date orderDate, String phone, Boolean status, float total_price, Account account) {
		super();
		this.address = address;
		this.orderDate = orderDate;
		this.phone = phone;
		this.status = status;
		this.total_price = total_price;
		this.account = account;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public float getTotal_price() {
		return total_price;
	}

	public void setTotal_price(float total_price) {
		this.total_price = total_price;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public List<Cart_items> getCart_Items() {
		return cart_Items;
	}

	public void setCart_Items(List<Cart_items> cart_Items) {
		this.cart_Items = cart_Items;
	} 
	
	
}
