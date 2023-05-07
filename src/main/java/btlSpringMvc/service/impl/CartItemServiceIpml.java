package btlSpringMvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import btlSpringMvc.dao.ICart_itemDao;
import btlSpringMvc.entities.Cart_items;
import btlSpringMvc.service.ICartItemsService;

@Service
public class CartItemServiceIpml implements ICartItemsService{
	
	@Autowired
	private ICart_itemDao cart_itemDao;

	@Override
	public List<Cart_items> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean save(Cart_items cart_items) {
		return cart_itemDao.save(cart_items);
	}

	@Override
	public Boolean delete(int id) {
		return cart_itemDao.delete(id);
	}

	@Override
	public Boolean update(Cart_items cart_items, int quantityNew) {
		return cart_itemDao.update(cart_items, quantityNew);
	}
	
}
