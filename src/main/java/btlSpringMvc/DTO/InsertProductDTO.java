package btlSpringMvc.DTO;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

public class InsertProductDTO {

	private Long id;

	@NotEmpty(message = "tên không được để trống")
	private String proName;

	@NotEmpty(message = "bạn phải chọn ảnh")
	private String imageName;

	@NotNull(message = "giá sản phẩm không được đê trống")
	private Float price;

	private Float sale_price;

	private String description;
	
	private MultipartFile fileUpload;
	
	private Long category_id;
	
	public InsertProductDTO() {
		// TODO Auto-generated constructor stub
	}

	public InsertProductDTO(
			@NotEmpty(message = "tên không được để trống") String proName,
			@NotEmpty(message = "bạn phải chọn ảnh") String imageName,
			@NotNull(message = "giá sản phẩm không được đê trống") Float price, Float sale_price, String description,
			@NotNull(message = "bạn phải chọn ảnh") MultipartFile fileUpload, Long category_id) {
		super();
		this.proName = proName;
		this.imageName = imageName;
		this.price = price;
		this.sale_price = sale_price;
		this.description = description;
		this.fileUpload = fileUpload;
		this.category_id = category_id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Float getSale_price() {
		return sale_price;
	}

	public void setSale_price(Float sale_price) {
		this.sale_price = sale_price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public MultipartFile getFileUpload() {
		return fileUpload;
	}

	public void setFileUpload(MultipartFile fileUpload) {
		this.fileUpload = fileUpload;
	}

	public Long getCategory_id() {
		return category_id;
	}

	public void setCategory_id(Long category_id) {
		this.category_id = category_id;
	}
	
}
