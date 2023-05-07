package btlSpringMvc.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cart_items")
public class Cart_items {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "product_details_id")
	private ProductDetails productDetails;
	
	private String colorName;
	
	private String sizeName;
	
	@ManyToOne
	@JoinColumn(name = "cart_id")
	private Cart cart;
	
	@ManyToOne
	@JoinColumn(name = "bill_id")
	private Receipts bill;
	
	private int quantity;
	
	private float new_price;
	
	public Cart_items() {
		
	}

	public Cart_items( ProductDetails productDetails, Cart cart, int quantity,String colorName,String sizeName, float new_price) {
		super();
		this.productDetails = productDetails;
		this.cart = cart;
		this.quantity = quantity;
		this.colorName = colorName;
		this.sizeName = sizeName;
		this.new_price = new_price;
	}
	

	public Cart_items(ProductDetails productDetails, String colorName, String sizeName, Cart cart, Receipts bill,
			int quantity, float new_price) {
		super();
		this.productDetails = productDetails;
		this.colorName = colorName;
		this.sizeName = sizeName;
		this.cart = cart;
		this.bill = bill;
		this.quantity = quantity;
		this.new_price = new_price;
	}

	public int getId() {
		return id;
	}
	
	public float getNew_price() {
		return new_price;
	}

	public void setNew_price(float new_price) {
		this.new_price = new_price;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ProductDetails getProductDetails() {
		return productDetails;
	}

	public void setProductDetails(ProductDetails productDetails) {
		this.productDetails = productDetails;
	}

	public int getQuantity() {
		return quantity;
	}
	
	public String getColorName() {
		return colorName;
	}

	public void setColorName(String colorName) {
		this.colorName = colorName;
	}

	public String getSizeName() {
		return sizeName;
	}

	public void setSizeName(String sizeName) {
		this.sizeName = sizeName;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Receipts getBill() {
		return bill;
	}

	public void setBill(Receipts bill) {
		this.bill = bill;
	}

}
