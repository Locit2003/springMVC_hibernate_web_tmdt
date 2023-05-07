package btlSpringMvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import btlSpringMvc.dao.IImagesDao;
import btlSpringMvc.entities.Images;

@Service
public class ImageServiceImpl implements IImgageService{

	@Autowired
	private IImagesDao imagesDao;
	
	@Override
	public List<Images> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Images> findAllByName(String nameImage) {
		return imagesDao.findAllByName(nameImage);
	}

	@Override
	public Boolean save(Images images) {
		return imagesDao.save(images);
	}

	@Override
	public Boolean update(Images images) {
		return imagesDao.update(images);
	}

	
}
