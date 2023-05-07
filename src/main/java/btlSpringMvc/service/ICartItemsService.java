package btlSpringMvc.service;

import java.util.List;

import btlSpringMvc.entities.Cart_items;

public interface ICartItemsService {
	List<Cart_items> findAll();
	Boolean save(Cart_items cart_items);
	Boolean delete(int id);
	Boolean update(Cart_items cart_items,int quantityNew);
}
