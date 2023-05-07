package btlSpringMvc.DTO;

public class ProductDetailsDTO {

	private Long proId;

	private String size;

	private String color;
	
	private int quantity;

	public ProductDetailsDTO() {

	}

	public ProductDetailsDTO(Long proId, String size, String color, int quantity) {
		super();
		this.proId = proId;
		this.size = size;
		this.color = color;
		this.quantity = quantity;
	}

	public Long getProId() {
		return proId;
	}

	public void setProId(Long proId) {
		this.proId = proId;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public int getQuantity() {
		return quantity;
	}
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
