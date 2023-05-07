package btlSpringMvc.entities;

import java.util.List;

import javax.persistence.*;
import javax.persistence.GenerationType;

@Entity
@Table(name="category")
public class Categories {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long catId;
	
	private String name;
	
	private Boolean status;
	
	@OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
	private List<Product> product;
	
	public Categories() {
		
	}

	
	public Categories(Long catId, String name, Boolean status, List<Product> product) {
		super();
		this.catId = catId;
		this.name = name;
		this.status = status;
		this.product = product;
	}


	public Long getCatId() {
		return catId;
	}

	public void setCatId(Long catId) {
		this.catId = catId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}


	public List<Product> getProduct() {
		return product;
	}


	public void setProduct(List<Product> product) {
		this.product = product;
	}
	
	
}
