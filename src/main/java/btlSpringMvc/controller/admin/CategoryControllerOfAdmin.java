package btlSpringMvc.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import btlSpringMvc.entities.Categories;
import btlSpringMvc.entities.Product;
import btlSpringMvc.entities.ProductDetails;
import btlSpringMvc.service.CategoryService;
import btlSpringMvc.service.ProductService;

@Controller
@RequestMapping("admin")
public class CategoryControllerOfAdmin {

	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "/category-list", method = RequestMethod.GET)
	public String category_list_page(Model model) {
		List<Categories> list = categoryService.findAll();
		model.addAttribute("cats", list);
		return "admin/category/list";
	}
	
	@RequestMapping(value = "/admin-category-add", method = RequestMethod.GET)
	public String category_add_page(Model model) {	
		model.addAttribute("cats",new Categories());
		return "admin/category/add";
	}
	
	@RequestMapping(value = "/category-edit/{id}", method = RequestMethod.GET)
	public String category_edit_page(@PathVariable("id") Long id,Model model) {
		Categories cat =  categoryService.getCategoryById(id);
		model.addAttribute("catUpdate",cat);
		model.addAttribute("category", cat);
		return "admin/category/edit";
	}
	
	@RequestMapping(value = "admin-category-insert", method = RequestMethod.POST)
	public String category_insert(@ModelAttribute("cats") Categories cats) {	
		categoryService.insert(cats);
		return "redirect:/admin/category-list";
	}

	@RequestMapping(value = "/category-edit/category-update", method = RequestMethod.POST)
	public String category_update(@ModelAttribute("catUpdate") Categories cat) {
		categoryService.update(cat);
		return "redirect:/admin/category-list";
	}
	
	
	@RequestMapping(value = "/category-delete/{id}", method = RequestMethod.GET)
	public String category_delete(@PathVariable("id") Long id) {
		if(categoryService.delete(id)) {
			System.out.println("da xoa thanh cong");
			return "redirect:/admin/category-list";
		}else {
			System.out.println("da xoa that bai");
			return "redirect:/admin/category-list";
		}
	}
	
	@GetMapping("/danh-muc/{id}")
	public String showProByCatId(@PathVariable("id") int catId,Model model) {
		List<Product> prods = productService.findAllCatId(catId);
		model.addAttribute("pros", prods);
		return "admin/product/listProductByCategory";
	}
}
