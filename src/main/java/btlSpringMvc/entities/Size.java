package btlSpringMvc.entities;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "size")
public class Size {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sizeId;
	
	private String sizeName;
	
	@OneToMany(mappedBy = "size")
	private List<Product_size> prod_size;
	
	public Size() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Size(int sizeId, String sizeName, List<Product_size> prod_size) {
		super();
		this.sizeId = sizeId;
		this.sizeName = sizeName;
		this.prod_size = prod_size;
	}


	public int getSizeId() {
		return sizeId;
	}

	public void setSizeId(int sizeId) {
		this.sizeId = sizeId;
	}

	public String getSizeName() {
		return sizeName;
	}

	public void setSizeName(String sizeName) {
		this.sizeName = sizeName;
	}

	public List<Product_size> getProd_size() {
		return prod_size;
	}

	public void setProd_size(List<Product_size> prod_size) {
		this.prod_size = prod_size;
	}
	
	
}
