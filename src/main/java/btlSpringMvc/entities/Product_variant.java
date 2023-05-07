package btlSpringMvc.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product_variant")
public class Product_variant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "prod_details_id")
	private ProductDetails productDetails;
	
	@ManyToOne
	@JoinColumn(name = "color_id")
	private Colors color;
	
	@ManyToOne
	@JoinColumn(name = "size_id")
	private Size size;
	
	private int quantity;
	
	private float price;

	public Product_variant() {
		// TODO Auto-generated constructor stub
	}
	
	public Product_variant(int id, ProductDetails productDetails, Colors color, Size size, int quantity, float price) {
		super();
		this.id = id;
		this.productDetails = productDetails;
		this.color = color;
		this.size = size;
		this.quantity = quantity;
		this.price = price;
	}

	public int getId() {
		return id;
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

	public Colors getColor() {
		return color;
	}

	public void setColor(Colors color) {
		this.color = color;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	
}
