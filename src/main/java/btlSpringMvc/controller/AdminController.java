package btlSpringMvc.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import btlSpringMvc.entities.CustomAccountDetails;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@RequestMapping("/welcome")
	public String adminPage(Model model) {
		model.addAttribute("mess", "Welcome to admin page");
		CustomAccountDetails ac = (CustomAccountDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("ac", ac);
		return "web/admin";
	}
}
