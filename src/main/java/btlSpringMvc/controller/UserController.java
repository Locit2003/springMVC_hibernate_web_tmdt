package btlSpringMvc.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import btlSpringMvc.entities.CustomAccountDetails;

@Controller
@RequestMapping("/abc")
public class UserController {
	@RequestMapping("/profile")
	public String userPage(Model model) {
		model.addAttribute("mess", "Welcome user page");
		CustomAccountDetails ac = (CustomAccountDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("ac", ac);
		return "web/profile";
	}
	
	@RequestMapping("/home")
	public String homePage(Model model) {
		ModelAndView mav = new ModelAndView("home");
		return "web/trang-chu";
	}
}
