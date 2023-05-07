package btlSpringMvc.service;

import java.util.List;

import btlSpringMvc.DTO.ProductDTO;
import btlSpringMvc.entities.Product;
import btlSpringMvc.entities.ProductDetails;

public interface ProductService {
	public List<ProductDetails> findAll();
	public boolean insert(Product p);
	public boolean insert(ProductDetails p);
	public boolean update(ProductDTO p);
	public boolean delete(Long proId);
	public ProductDetails findById(Long proId);
	public Product getCategoryById(int proId);
	public List<Product> findAllCatId(int catId);
}
