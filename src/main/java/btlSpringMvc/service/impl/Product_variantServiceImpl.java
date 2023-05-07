package btlSpringMvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import btlSpringMvc.dao.IProduct_variant;
import btlSpringMvc.entities.Product_variant;
import btlSpringMvc.service.IProduct_variantService;

@Service
public class Product_variantServiceImpl implements IProduct_variantService{

	@Autowired
	private IProduct_variant variantDao;
	
	@Override
	public List<Product_variant> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean insert(Product_variant pro_variant) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product_variant> findByAll(Long proDetai_id, int color_id, int size_id) {
		List<Product_variant> pro_variant = variantDao.findByAll(proDetai_id, color_id, size_id);
		return pro_variant;
	}

}
