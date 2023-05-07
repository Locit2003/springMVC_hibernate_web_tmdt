package btlSpringMvc.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "products_sizes")
public class Product_size {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "prod_details_id")
	private ProductDetails productDetails;
	
	@ManyToOne
	@JoinColumn(name = "sizeId")
	private Size size;
	
	public Product_size() {
		// TODO Auto-generated constructor stub
	}

	public Product_size(int id, ProductDetails productDetails, Size size) {
		super();
		this.id = id;
		this.productDetails = productDetails;
		this.size = size;
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

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}
	
	
}
