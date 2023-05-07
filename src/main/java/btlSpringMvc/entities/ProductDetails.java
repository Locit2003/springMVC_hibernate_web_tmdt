package btlSpringMvc.entities;

import java.util.Set;

import javax.persistence.*;

@Entity
public class ProductDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "imgId")
	private Images image;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "prodId")
	private Product product;
	
	@OneToMany(mappedBy = "productDetails",fetch = FetchType.EAGER)
	private Set<Products_Color> products_color;
	
	@OneToMany(mappedBy = "productDetails",fetch = FetchType.EAGER)
	private Set<Product_size> products_sizes;

	@OneToMany(mappedBy = "productDetails")
	private Set<Cart_items> cart_item;
	
	public ProductDetails() {
		// TODO Auto-generated constructor stub
	}
	
	public ProductDetails(Long id, Images image, Product product, Set<Products_Color> products_color,
			Set<Product_size> products_sizes, Set<Cart_items> cart_item) {
		super();
		this.id = id;
		this.image = image;
		this.product = product;
		this.products_color = products_color;
		this.products_sizes = products_sizes;
		this.cart_item = cart_item;
	}

	
	public ProductDetails(Images image, Product product, Set<Products_Color> products_color,
			Set<Product_size> products_sizes, Set<Cart_items> cart_item) {
		super();
		this.image = image;
		this.product = product;
		this.products_color = products_color;
		this.products_sizes = products_sizes;
		this.cart_item = cart_item;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Images getImage() {
		return image;
	}

	public void setImage(Images image) {
		this.image = image;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Set<Products_Color> getProducts_color() {
		return products_color;
	}

	public void setProducts_color(Set<Products_Color> products_color) {
		this.products_color = products_color;
	}


	public Set<Product_size> getProducts_sizes() {
		return products_sizes;
	}


	public void setProducts_sizes(Set<Product_size> products_sizes) {
		this.products_sizes = products_sizes;
	}


	public Set<Cart_items> getCart_item() {
		return cart_item;
	}

	public void setCart_item(Set<Cart_items> cart_item) {
		this.cart_item = cart_item;
	}
	
	
}
