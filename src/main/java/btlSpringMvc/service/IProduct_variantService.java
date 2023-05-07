package btlSpringMvc.service;

import java.util.List;

import btlSpringMvc.entities.Product_variant;

public interface IProduct_variantService {
	public List<Product_variant> findAll();
	public Boolean insert(Product_variant pro_variant);
	public List<Product_variant> findByAll(Long proDetai_id,int color_id,int size_id);
}
