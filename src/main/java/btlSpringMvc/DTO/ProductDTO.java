package btlSpringMvc.DTO;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

public class ProductDTO {
private int id;
	

	@NotEmpty(message = "tên không được để trống")
	@Length(min = 3, message = "tên sản phẩm phải có ít nhất 3 ký tự")
	private String name;

	@NotNull(message = "giá sản phẩm không được đê trống")
	private Float price;

	private Float sale_price;

	private String description;
	
	private Long category_id;
	
	private Boolean status;
	
	public ProductDTO() {
		// TODO Auto-generated constructor stub
	}
	

	public ProductDTO(int id,
			@NotEmpty(message = "tên không được để trống") @Length(min = 3, message = "tên sản phẩm phải có ít nhất 3 ký tự") String name,
			@NotNull(message = "giá sản phẩm không được đê trống") Float price, Float sale_price, String description,
			Long category_id, Boolean status) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.sale_price = sale_price;
		this.description = description;
		this.category_id = category_id;
		this.status = status;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
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


	public Long getCategory_id() {
		return category_id;
	}


	public void setCategory_id(Long category_id) {
		this.category_id = category_id;
	}


	public Boolean getStatus() {
		return status;
	}


	public void setStatus(Boolean status) {
		this.status = status;
	}

}
