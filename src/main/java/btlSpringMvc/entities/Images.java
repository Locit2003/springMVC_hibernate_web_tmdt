package btlSpringMvc.entities;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "images",uniqueConstraints = {
		@UniqueConstraint(columnNames = "imgName")
		})
public class Images {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int imageId;

	@Column(name = "imgName")
	private String imgName;
	
	@OneToMany(mappedBy = "image")
	private List<ProductDetails> productDetails;
	
	public Images() {
		// TODO Auto-generated constructor stub
	}

	public Images(int imageId, String imgName, List<ProductDetails> productDetails) {
		super();
		this.imageId = imageId;
		this.imgName = imgName;
		this.productDetails = productDetails;
	}
	
	public Images(String imgName, List<ProductDetails> productDetails) {
		super();
		this.imgName = imgName;
		this.productDetails = productDetails;
	}

	public int getImageId() {
		return imageId;
	}

	public void setImageId(int imageId) {
		this.imageId = imageId;
	}

	public String getImgName() {
		return imgName;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
	}

	public List<ProductDetails> getProductDetails() {
		return productDetails;
	}

	public void setProductDetails(List<ProductDetails> productDetails) {
		this.productDetails = productDetails;
	}
	
	
}
