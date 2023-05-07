package btlSpringMvc.controller.admin;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import btlSpringMvc.DTO.InsertProductDTO;
import btlSpringMvc.entities.Images;
import btlSpringMvc.entities.Product;
import btlSpringMvc.entities.ProductDetails;
import btlSpringMvc.service.CategoryService;
import btlSpringMvc.service.IImgageService;
import btlSpringMvc.service.ProductService;

@Controller(value = "productControllerofAdmin")
@RequestMapping("admin")
public class ProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private IImgageService imgageService;

	@GetMapping(value = "/product-list")
	public String product_list_page(Model model) {
		List<ProductDetails> listPros = productService.findAll();
		
		model.addAttribute("prods", listPros);
		for (ProductDetails productEntity : listPros) {
			model.addAttribute("cat", productEntity.getProduct().getCategory().getName());
		}
		
		return "admin/product/list";
	}

	@GetMapping(value = "/product-add")
	public String product_add_page(Model model) {
		model.addAttribute("insertProductDTO", new InsertProductDTO());
		model.addAttribute("categories", categoryService.findAll());
		return "admin/product/add";
	}

	@PostMapping(value = "insert-product")
	public String uploadFile(@ModelAttribute("insertProductDTO") InsertProductDTO pro, Model model, HttpServletRequest req,
			@RequestParam("fileUpload") MultipartFile imgFile) {

		try {
			MultipartFile multipartFile = pro.getFileUpload();
			String fileName = multipartFile.getOriginalFilename();
			String path = "C:\\Users\\ADMIN\\Desktop\\btl-springMVC\\btl-springMVC\\Bai_Tap_Lon_Spring_Hibernate\\src\\main\\webapp\\template\\image";
			File file = new File(path, fileName);
			multipartFile.transferTo(file);
			pro.setImageName(fileName);
			if (pro.getImageName() != null && imgageService.findAllByName(fileName).size()<=0) {
				Product prod = new Product(pro.getProName(), true, pro.getPrice(), pro.getSale_price(), pro.getDescription(), categoryService.getCategoryById(pro.getCategory_id()));
				Images images = new Images(fileName, null);
				imgageService.save(images);
				ProductDetails productDetails = new ProductDetails(imgageService.findAllByName(fileName).get(0), prod, null, null, null);
				productService.insert(prod);
				productService.insert(productDetails);
				model.addAttribute("message", "upload success");
				return "redirect:/admin/product-list";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", "upload failed");
			return "admin/product/add";
		}
		return "redirect:/admin/product-list";
	}
	
	@GetMapping(value = "/product/delete/{id}")
	public String deleteProduct(@PathVariable("id") Long id,Model model) {
		Boolean bl = productService.delete(id);
		if(bl) {
			model.addAttribute("deleteSuccess", "xóa thành công sản phẩm có id = "+id);
			return "redirect:/admin/product-list";
		}
		model.addAttribute("deleteFalie", "xóa thất bại sản phẩm có id = "+id);
		return "redirect:/admin/product-list";
	}
	

//	@GetMapping(value = "/edit/{id}")
//	public String product_edit_page(Model model,@PathVariable("id") Long id) {
//		ProductDTO prod = new ProductDTO();
//		prod.setId(productService.findById(id).getId());
//		prod.setName(productService.findById(id).getName());
//		prod.setImage(productService.findById(id).getImage());
//		prod.setPrice(productService.findById(id).getPrice());
//		prod.setSale_price(productService.findById(id).getSale_price());
//		prod.setDescription(productService.findById(id).getDescription());
//		prod.setCategory_id(productService.findById(id).getCategory_id().getId());
//		model.addAttribute("productDTO", prod);
//		model.addAttribute("categories", categoryService.findAll());
//		return "admin/product/edit";
//	}
//	
//	@PostMapping(value = "edit/edit-product")
//	public String update_product(@ModelAttribute("productDTO") ProductDTO pro, Model model, HttpServletRequest req,
//			@RequestParam("fileUpload") MultipartFile imgFile) {
//		try {
//			MultipartFile multipartFile = pro.getFileUpload();
//			String fileName = multipartFile.getOriginalFilename();
//			if(!(fileName == productService.findById(pro.getId()).getImage())) {
//				String path = "C:\\Users\\ADMIN\\git\\project-spring-mvc-hibernate\\src\\main\\webapp\\template\\image";
//				File file = new File(path, fileName);
//				multipartFile.transferTo(file);
//				model.addAttribute("message", "Update success!");
//				pro.setImage(fileName);
//				if (pro.getImage() != null) {
//					productService.update(pro);
//					return "redirect:/admin/product/list";
//				}
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			model.addAttribute("message", "Edit failed !");
//			return "admin/product/edit";
//		}
//		return "redirect:/admin/product/list";
//	}
}
