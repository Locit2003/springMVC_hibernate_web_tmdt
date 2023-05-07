package btlSpringMvc.service;

import btlSpringMvc.entities.Cart_items;

public interface ICheckCartItemService {
	public Boolean checkProdCartItem(Cart_items cart_items,int quantityNew);
}
