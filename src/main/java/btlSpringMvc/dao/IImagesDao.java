package btlSpringMvc.dao;

import java.util.List;

import btlSpringMvc.entities.Images;

public interface IImagesDao {
	public List<Images> findAll();
	public List<Images> findAllByName(String nameImage);
	public Boolean save(Images images);
	public Boolean update(Images images);
}
