package btlSpringMvc.entities;

import javax.persistence.*;

@Entity
@Table(name = "products_color")
public class Products_Color {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "prod_details_id")
	private ProductDetails productDetails;
	
	@ManyToOne
	@JoinColumn(name = "color_id")
	private Colors color;

	public Products_Color() {
		// TODO Auto-generated constructor stub
	}
	
	public Products_Color(int id, ProductDetails productDetails, Colors color) {
		super();
		this.id = id;
		this.productDetails = productDetails;
		this.color = color;
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
	
	
}
