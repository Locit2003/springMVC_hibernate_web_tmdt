package btlSpringMvc.controller.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import btlSpringMvc.controller.taopass;
import btlSpringMvc.entities.Account;
import btlSpringMvc.entities.Account_roles;
import btlSpringMvc.entities.Cart;
import btlSpringMvc.entities.Role;
import btlSpringMvc.service.ICartService;
import btlSpringMvc.service.IUserService;

@Controller
public class RegisterController {
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private ICartService cartService;
	
	@GetMapping("auth/register")
	public String registerAccPage(Model model) {
		model.addAttribute("account", new Account());
		return "admin/account/register";
	}
	
	@PostMapping("auth/register")
	public String doRegisterAcc(@Valid @ModelAttribute("account") Account account, BindingResult result) {
		
		if(result.hasErrors()) {
			return "admin/account/register";
		}
		
		try {
			taopass pass = new taopass(account.getPassword());
			account.setPassword(pass.getPassword());
			account.setEnabled(true);
			userService.save(account);
			cartService.insert(new Cart(account, null, 0, null, null, true, null));
			Role role = new Role();
			role.setId(2L);
			Account_roles acc_role = new Account_roles(null, account, role);
			userService.save(acc_role);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "admin/account/login-auth";
	}
}
