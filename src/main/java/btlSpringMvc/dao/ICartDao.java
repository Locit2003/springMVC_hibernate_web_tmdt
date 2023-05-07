package btlSpringMvc.dao;

import java.util.List;

import btlSpringMvc.entities.Cart;

public interface ICartDao {
	public List<Cart> findAll();
	public Boolean save(Cart c);
	public Cart findCartOfMe(Long proId);
	public Boolean update(Cart c);
}
