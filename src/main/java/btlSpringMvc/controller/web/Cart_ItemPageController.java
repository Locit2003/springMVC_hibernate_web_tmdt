package btlSpringMvc.controller.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import btlSpringMvc.entities.Cart;
import btlSpringMvc.entities.Cart_items;
import btlSpringMvc.entities.CustomAccountDetails;
import btlSpringMvc.entities.Receipts;
import btlSpringMvc.service.IBill_Service;
import btlSpringMvc.service.ICartItemsService;
import btlSpringMvc.service.ICartService;

@Controller
@RequestMapping("/user")
public class Cart_ItemPageController {
	
	@Autowired
	private ICartService cartService;
	
	@Autowired
	private ICartItemsService cartItemsService;
	
	@GetMapping("/cart-items")
	public String cartPage(Model model) {
		CustomAccountDetails ac = (CustomAccountDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Cart cart = cartService.findCartOfMe(ac.getId());
		List<Cart_items> listCartItem = new ArrayList<>();
		float total_price = 0;
		for (Cart_items cart2 :  cart.getCart_items()) {
			listCartItem.add(cart2);
			if(cart2.getNew_price()>0) {
				total_price += cart2.getNew_price()*cart2.getQuantity();
			}else {
				total_price+= cart2.getProductDetails().getProduct().getPrice()*cart2.getQuantity();
			}
		}
			model.addAttribute("cart_items", listCartItem);
			model.addAttribute("address", cart.getAddress());
			model.addAttribute("phone", cart.getPhoneNumber());
			model.addAttribute("total", total_price);
		return "web/cart-item";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteCartItem(@PathVariable("id") int id) {
		if(cartItemsService.delete(id)) {
			return "redirect:/user/cart-items";
		}
		return "redirect:/user/cart-items";
	}
	
	@PostMapping("add-info-customer")
	public String add_info_customer(Model model, @RequestParam("address") String address,@RequestParam("phoneNumber") String phone) {
		CustomAccountDetails ac = (CustomAccountDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Cart cart = cartService.findCartOfMe(ac.getId());
		cart.setAddress(address);
		cart.setPhoneNumber(phone);
		Boolean bl = cartService.update(cart);
		if(bl) {
			return "redirect:/user/cart-items";
		}
		return "redirect:/user/cart-items";
	}
}
