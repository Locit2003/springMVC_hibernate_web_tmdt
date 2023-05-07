package btlSpringMvc.service;

import java.util.List;

import btlSpringMvc.entities.Cart;

public interface ICartService {
	public Cart findCartOfMe(Long userId);
	public Boolean insert(Cart c);
	public Boolean update(Cart c);
	public Boolean updateCartNull(Cart c);
}
