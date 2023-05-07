package btlSpringMvc.dao;

import java.util.List;

import btlSpringMvc.entities.Product;
import btlSpringMvc.entities.ProductDetails;

public interface IProductDao {
	public List<ProductDetails> findAll();
	public boolean insert(Product p);
	public boolean insert(ProductDetails p);
	public boolean update(Product p);
	public boolean delete(Long proId);
	public ProductDetails findByIdOfProductDetails(Long id);
	public Product findByIdOfproduct(int id);
	public Product getCategoryById(int proId);
	public List<Product> findAllCatId(int catId);
}
