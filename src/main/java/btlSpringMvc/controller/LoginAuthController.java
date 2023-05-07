package btlSpringMvc.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.captcha.botdetect.web.servlet.Captcha;

import btlSpringMvc.entities.Account;
import btlSpringMvc.service.impl.CustomAccountDetailService;


@Controller
@RequestMapping("/auth")
public class LoginAuthController {

	@Autowired
	private CustomAccountDetailService customer;
	
	@RequestMapping("/login")
	public String login(@RequestParam(value = "error",required = false) String error, Model model) {
		if(error!=null) {
			model.addAttribute("ness", "login false");
		}
		return "login";
		
	}

	@GetMapping("/login-admin")
	public String loginForm(@RequestParam(value = "error",required = false) String error,Model model) {
		if(error!=null) {
			model.addAttribute("ness", "login false");
		}
		return "admin/account/login-auth";
	}

	@PostMapping("/login")
	public String loginSubmit( HttpServletRequest request, Model model, @Valid @ModelAttribute("basicExample") BasicExample basicExample) {
		Captcha captcha = Captcha.load(request, "basicExample");
		boolean isHuman = captcha.validate(basicExample.getCaptchaCode());

		if (isHuman) {
//			HttpSession session = request.getSession();
//			session.setAttribute("loggedInUser", userLogin);
			model.addAttribute("basicExample", basicExample);
			return "redirect:/user/home";
		} else {
			basicExample.setCaptchaCorrect("");
			basicExample.setCaptchaIncorrect("Incorrect code");
			model.addAttribute("basicExample", basicExample);
			return "redirect:/auth/login-admin";
		}
	}

	@GetMapping("/logout-admin")
	public String logoutForm() {

		return null;
	}
}
