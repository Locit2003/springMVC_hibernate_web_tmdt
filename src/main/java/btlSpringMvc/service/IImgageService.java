package btlSpringMvc.service;

import java.util.List;

import btlSpringMvc.entities.Images;

public interface IImgageService {
	public List<Images> findAll();
	public List<Images> findAllByName(String nameImage);
	public Boolean save(Images images);
	public Boolean update(Images images);
}
