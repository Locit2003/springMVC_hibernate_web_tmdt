package btlSpringMvc.controller.web;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import btlSpringMvc.DTO.ProductDetailsDTO;
import btlSpringMvc.entities.Account;
import btlSpringMvc.entities.Cart;
import btlSpringMvc.entities.Cart_items;
import btlSpringMvc.entities.CustomAccountDetails;
import btlSpringMvc.entities.ProductDetails;
import btlSpringMvc.entities.Product_variant;
import btlSpringMvc.entities.Products_Color;
import btlSpringMvc.service.ICartItemsService;
import btlSpringMvc.service.ICartService;
import btlSpringMvc.service.ICheckCartItemService;
import btlSpringMvc.service.IProduct_variantService;
import btlSpringMvc.service.IUserService;
import btlSpringMvc.service.ProductService;

@Controller
public class DetailsPageControllerOfWeb{
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ICartService cartService;
	
	@Autowired
	private ICartItemsService cartItemsService;
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IProduct_variantService product_variantService;
	
	@Autowired
	private ICheckCartItemService checkCartItemService;
	
	
	
	@GetMapping("/chi-tiet-san-pham/{id}")
	public String detailsPage(@PathVariable("id") Long id,Model model) {
		model.addAttribute("productDetailsDTO", new ProductDetailsDTO());
		model.addAttribute("proDetails", productService.findById(id));
		return "web/details-product";
	}
	
	@PostMapping("chi-tiet-san-pham/add-to-cart")
	@PreAuthorize("isAuthenticated()")
	public String addToCart(Model model,@RequestParam("action") String action,
			@ModelAttribute("productDetailsDTO") ProductDetailsDTO prod) {
		CustomAccountDetails ac = (CustomAccountDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Account user = userService.findById(ac.getId());
		int sizeCartOfUser = user.getCart().size();
		if(sizeCartOfUser<=0) {
			cartService.insert(new Cart(userService.findById(ac.getId()), null, 0, null, null, true, null));
		}
		
		int colorId = Integer.parseInt(prod.getColor());
		int sizeId = Integer.parseInt(prod.getSize());
		List<Product_variant> prod_variant = product_variantService.findByAll(prod.getProId(),colorId , sizeId);
		if(prod_variant.size()>0) {
			float new_price = 0;
			String colorName = null;
			String sizeName = null;
			for (Product_variant prdv : prod_variant) {
				if(prdv.getPrice() >= 0) {
					new_price = prdv.getPrice();
					colorName = prdv.getColor().getColorName();
					sizeName = prdv.getSize().getSizeName();
					break;
				}
			}
			
			ProductDetails prodetails = productService.findById(prod.getProId());
			try {
				Cart_items cart_items = new Cart_items(prodetails, user.getCart().get(0), prod.getQuantity(),colorName,sizeName,new_price);
				checkCartItemService.checkProdCartItem(cart_items,prod.getQuantity());
				return "redirect:/user/cart-items";
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "redirect:/chi-tiet-san-pham/"+prod.getProId();
		}else {
			model.addAttribute("thong_bao", "không có sản phẩm có size và màu này");
			return "redirect:/chi-tiet-san-pham/"+prod.getProId();
		}
	}
}
