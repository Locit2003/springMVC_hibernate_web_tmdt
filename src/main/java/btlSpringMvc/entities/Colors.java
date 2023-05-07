package btlSpringMvc.entities;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "colors")
public class Colors {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int colorId;
	
	@Column(name = "colorName")
	private String colorName;
	
	@OneToMany(mappedBy = "color")
	private List<Products_Color> products_Color;

	public Colors() {
		// TODO Auto-generated constructor stub
	}
	
	public Colors(int colorId, String colorName, List<Products_Color> products_Color) {
		super();
		this.colorId = colorId;
		this.colorName = colorName;
		this.products_Color = products_Color;
	}

	public int getColorId() {
		return colorId;
	}

	public void setColorId(int colorId) {
		this.colorId = colorId;
	}

	public String getColorName() {
		return colorName;
	}

	public void setColorName(String colorName) {
		this.colorName = colorName;
	}

	public List<Products_Color> getProducts_Color() {
		return products_Color;
	}

	public void setProducts_Color(List<Products_Color> products_Color) {
		this.products_Color = products_Color;
	}

}
