package btlSpringMvc.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import btlSpringMvc.dao.ICartDao;
import btlSpringMvc.entities.Cart;
import btlSpringMvc.service.ICartService;

@Service
public class CartServiceImpl implements ICartService{
	
	@Autowired
	private ICartDao cartDao;

	@Override
	public Cart findCartOfMe(Long userId) {
		return cartDao.findCartOfMe(userId);
	}

	@Override
	public Boolean insert(Cart c) {
		return cartDao.save(c);
	}

	@Override
	public Boolean update(Cart c) {
		return cartDao.update(c);
	}

	@Override
	public Boolean updateCartNull(Cart c) {
		Cart cartNull = new Cart(c.getCartId(), c.getAccount(), null, 0, null, null, null, null);
		return cartDao.update(cartNull);
	}
	

}
