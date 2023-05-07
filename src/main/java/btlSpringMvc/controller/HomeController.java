package btlSpringMvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import btlSpringMvc.entities.Account;

@Controller
public class HomeController {

//	@RequestMapping(value = { "/", "/login" })
//	public String homePage(Model model) {
//		ModelAndView mav = new ModelAndView("home");
//		return "web/demo";
//	}
	
	
	@RequestMapping("/home")
	public String homePage(Model model) {
		ModelAndView mav = new ModelAndView("home");
		return "web/trang-chu";
	}

	@RequestMapping("/cart")
	public String cartPage(Model model) {
		ModelAndView mav = new ModelAndView("home");
		return "web/cart";
	}

	@RequestMapping("/detail")
	public String detailPage(Model model) {
		ModelAndView mav = new ModelAndView("home");
		return "web/detail";
	}

	
//	@RequestMapping(value = { "/", "/login"})
//	public String login(@RequestParam(value = "error", required = false)String error, Model model) {
//		if(error!=null) {
//			model.addAttribute("mess", "Login failed!");
//		}
//		return "admin/account/login-auth";
//	}
	
	
	
	@RequestMapping("/register")
	public String registerPage(Model model) {
		Account ac = new Account();
	    model.addAttribute("ac", ac);
		return "web/register";
	}
	
	
//	@RequestMapping("/proFile")
//	public String proFilePage(Model model) {
//		return "web/profile";
//	}
	

	@RequestMapping("/logout")
	public String logout(Model model) {
		model.addAttribute("mess", "Has Logged out!!!");
		return "web/login";
	}
}
