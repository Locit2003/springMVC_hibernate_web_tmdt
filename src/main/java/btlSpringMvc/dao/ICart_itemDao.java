package btlSpringMvc.dao;

import java.util.List;

import btlSpringMvc.DTO.ProductDetailsDTO;
import btlSpringMvc.entities.Cart_items;

public interface ICart_itemDao {
	List<Cart_items> findAll();
	Boolean save(Cart_items cart_items);
	Boolean findProInCartItem(Long proId,String colorName, String sizeName,int accId,int quantity);
	Boolean update(Cart_items cart_items,int quantityNew);
	Boolean delete(int id);
	Cart_items findById(int id);
}
