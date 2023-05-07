package btlSpringMvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import btlSpringMvc.dao.ICategoryDao;
import btlSpringMvc.entities.Categories;
import btlSpringMvc.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private ICategoryDao categoryDao;

	@Override
	public List<Categories> findAll() {
		return categoryDao.findAll();
	}

	@Override
	public boolean insert(Categories c) {
		if(categoryDao.insert(c)) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean update(Categories c) {
		if(categoryDao.update(c)) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean delete(Long proId) {
		if(categoryDao.delete(proId)) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public Categories getCategoryById(Long catId) {
		return categoryDao.getCategoryById(catId);
	}
}
