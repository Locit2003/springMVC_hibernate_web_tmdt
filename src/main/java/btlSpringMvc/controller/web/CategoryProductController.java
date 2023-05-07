package btlSpringMvc.controller.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import btlSpringMvc.entities.Product;
import btlSpringMvc.service.ProductService;

@Controller
public class CategoryProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("danh-muc/{id}")
	public String showProByCatId(@PathVariable("id") int catId,Model model) {
		List<Product> prods = productService.findAllCatId(catId);
		model.addAttribute("pros", prods);
		return "web/product/shopByCategory";
	}
	
}
