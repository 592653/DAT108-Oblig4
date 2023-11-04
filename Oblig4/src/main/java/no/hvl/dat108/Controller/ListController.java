package no.hvl.dat108.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpServletRequest;
import no.hvl.dat108.InputValidator;
import no.hvl.dat108.Util.LoginUtil;

@Controller
@RequestMapping("/deltagerliste")
public class ListController {

	//get logut
	@GetMapping
	public String loggUt() {
		return "logginview";
	}
	
	//post loggut
	//redirect loggin
	@PostMapping
	public String loggetUt() {
		return "redirect:loggUt";
	}
}
