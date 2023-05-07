package btlSpringMvc.entities;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "product",uniqueConstraints = {
		@UniqueConstraint(columnNames = "name")
		})
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int proId;
	
	private String name;
	
	private Boolean status;
	
	private float price;
	
	private float sale_price;
	
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "catId")
	private Categories category;
	
	@OneToMany(mappedBy = "product",fetch = FetchType.EAGER)
	private List<ProductDetails> productDetails;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}



	public Product(int proId, String name, Boolean status, float price, float sale_price, String description,
			Categories category, List<ProductDetails> productDetails) {
		super();
		this.proId = proId;
		this.name = name;
		this.status = status;
		this.price = price;
		this.sale_price = sale_price;
		this.description = description;
		this.category = category;
		this.productDetails = productDetails;
	}

	public Product(int proId, String name, Boolean status, float price, float sale_price, String description,
			Categories category) {
		super();
		this.proId = proId;
		this.name = name;
		this.status = status;
		this.price = price;
		this.sale_price = sale_price;
		this.description = description;
		this.category = category;
	}
	

	public Product(String name, Boolean status, float price, float sale_price, String description,
			Categories category) {
		super();
		this.name = name;
		this.status = status;
		this.price = price;
		this.sale_price = sale_price;
		this.description = description;
		this.category = category;
	}



	public int getProId() {
		return proId;
	}

	public void setProId(int proId) {
		this.proId = proId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
	public List<ProductDetails> getProductDetails() {
		return productDetails;
	}



	public void setProductDetails(List<ProductDetails> productDetails) {
		this.productDetails = productDetails;
	}



	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getSale_price() {
		return sale_price;
	}

	public void setSale_price(float sale_price) {
		this.sale_price = sale_price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Categories getCategory() {
		return category;
	}

	public void setCategory(Categories category) {
		this.category = category;
	}
	
}
