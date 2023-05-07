package btlSpringMvc.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import btlSpringMvc.entities.Receipts;
import btlSpringMvc.service.IBill_Service;

@Controller
@RequestMapping("admin")
public class BillController {
	
	@Autowired
	private IBill_Service bill_Service;

	@GetMapping("/bills")
	public String billPage(Model model) {
		List<Receipts> bills = bill_Service.findAllBill();
		model.addAttribute("bills", bills);
		return "admin/bills/list";
	}
}
