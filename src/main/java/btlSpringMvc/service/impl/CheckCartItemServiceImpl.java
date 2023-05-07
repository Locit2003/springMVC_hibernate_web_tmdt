package btlSpringMvc.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import btlSpringMvc.dao.ICart_itemDao;
import btlSpringMvc.entities.Cart_items;
import btlSpringMvc.entities.ProductDetails;
import btlSpringMvc.entities.Products_Color;
import btlSpringMvc.service.ICheckCartItemService;

@Service
public class CheckCartItemServiceImpl implements ICheckCartItemService{

	@Autowired
	private ICart_itemDao cart_itemDao;
	
	@Override
	public Boolean checkProdCartItem(Cart_items cart_items,int quantityNew) {
		if(cart_itemDao.findProInCartItem(cart_items.getProductDetails().getId(), cart_items.getColorName(), cart_items.getSizeName(),cart_items.getCart().getCartId(),quantityNew)) {
			return true;
		}else {
			return cart_itemDao.save(cart_items);
		}
	}
	
}
