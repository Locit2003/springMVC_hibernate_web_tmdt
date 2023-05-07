package btlSpringMvc.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("admin")
public class HomeControllerOfAdmin {

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String homePage() {
		return "admin/home";
	}
}
