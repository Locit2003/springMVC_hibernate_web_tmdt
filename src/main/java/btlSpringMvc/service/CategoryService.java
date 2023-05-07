package btlSpringMvc.service;

import java.util.List;

import btlSpringMvc.entities.Categories;

public interface CategoryService {
	List<Categories> findAll();
	public boolean insert(Categories c);
	public boolean update(Categories c);
	public boolean delete(Long proId);
	public Categories getCategoryById(Long catId);
}
