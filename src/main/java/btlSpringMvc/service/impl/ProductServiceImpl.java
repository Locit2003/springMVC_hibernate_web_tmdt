package btlSpringMvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import btlSpringMvc.DTO.ProductDTO;
import btlSpringMvc.dao.ICategoryDao;
import btlSpringMvc.dao.IProductDao;
import btlSpringMvc.entities.Product;
import btlSpringMvc.entities.ProductDetails;
import btlSpringMvc.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ICategoryDao categoryDao;
	
	@Autowired
	private IProductDao productDao;
	
	@Override
	public List<ProductDetails> findAll() {
		List<ProductDetails> list = productDao.findAll();
		return list;
	}

	@Override
	public boolean insert(Product p) {
		return productDao.insert(p);
	}

	@Override
	public boolean update(ProductDTO p) {
		Product prod = new Product(p.getId(), p.getName(), p.getStatus(), p.getPrice(), p.getSale_price(), p.getDescription(), categoryDao.getCategoryById(p.getCategory_id()));
		return productDao.update(prod);
	}

	@Override
	public boolean delete(Long proId) {
		return productDao.delete(proId);
	}

	@Override
	public ProductDetails findById(Long proId) {
		return productDao.findByIdOfProductDetails(proId);
	}

	@Override
	public Product getCategoryById(int proId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> findAllCatId(int catId) {
		return productDao.findAllCatId(catId);
	}

	@Override
	public boolean insert(ProductDetails p) {
		return productDao.insert(p);
	}

	
}
