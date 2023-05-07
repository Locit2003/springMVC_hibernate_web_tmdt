package btlSpringMvc.controller.web;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
public class Checkout {
	
	@Autowired
	private ICartService cartService;
	
	@Autowired
	private ICartItemsService cartItemsService;
	
	@Autowired
	private IBill_Service bill_Service;

	
	@PostMapping("/thanh-toan")
	public String checkout(@RequestParam("total") float total_priceOfCart, Model model) {
		System.out.println("gia: "+total_priceOfCart);
		if(total_priceOfCart == 0) {
			return "redirect:/user/cart-items";
		}
		CustomAccountDetails ac = (CustomAccountDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Cart cart = cartService.findCartOfMe(ac.getId());
		if(cart!=null && cart.getAddress() == null && cart.getPhoneNumber() == null) {
			model.addAttribute("error", "vui lòng nhập đủ thông tin giao hàng");
			return "redirect:/user/cart-items";
		}
		Date now = new Date();
		cart.setTotalPrice(total_priceOfCart);
		cart.setOrderDate(now);
		cartService.update(cart);
		Receipts bill = new Receipts(cart.getAddress(), cart.getOrderDate(),cart.getPhoneNumber(), cart.getStatus(), cart.getTotalPrice(), cart.getAccount());
		Boolean blCreateBill = bill_Service.insert(bill);
		Boolean blUpdateCart = cartService.updateCartNull(cart);
		List<Receipts> billOfCus = bill_Service.findByUserId(cart.getAccount().getId());
		for (Cart_items cartItem : cart.getCart_items()) {
			cartItem.setBill(billOfCus.get(0));
			cartItem.setCart(null);
			cartItemsService.update(cartItem, 0);
		}
		if(blUpdateCart && blCreateBill) {
			model.addAttribute("success", "thanh toán thành công");
			return "redirect:/user/cart-items";
		}
		model.addAttribute("err", "thanh toán thất bại");
		return "redirect:/user/cart-items";
	}
	
}
