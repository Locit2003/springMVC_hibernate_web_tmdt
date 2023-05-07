package btlSpringMvc.controller.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import btlSpringMvc.entities.Categories;
import btlSpringMvc.entities.CustomAccountDetails;
import btlSpringMvc.entities.Product;
import btlSpringMvc.entities.ProductDetails;
import btlSpringMvc.service.CategoryService;
import btlSpringMvc.service.ProductService;

@Controller
@RequestMapping("/")
public class HomeControllerOfWeb {

	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = {"/trang-chu","/user/trang-chu"}, method = RequestMethod.GET)
	public String homePage(Model model) {
		
//		  ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-mail.xml");
//		    MailSender mailSender = (MailSender) context.getBean("mailSender2");
//		    System.out.println("Sending text...");
//		    SimpleMailMessage message = new SimpleMailMessage();
//		    message.setFrom("locit2003@gmail.com");
//		    message.setTo("locpham5155@gmail.com");
//		    message.setSubject("Subject");
//		    message.setText("test send gmail using spring");
//		    // sending message
//		    mailSender.send(message);
//		    System.out.println("Sending text done!");
//		    context.close();
		
		try {
			CustomAccountDetails ac = (CustomAccountDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			model.addAttribute("acc", ac);			
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<Categories> listCats = categoryService.findAll();
		List<ProductDetails> listPros = productService.findAll();
		model.addAttribute("cats", listCats);
		model.addAttribute("pros", listPros);
	
		return "web/trang-chu";
	}
}
