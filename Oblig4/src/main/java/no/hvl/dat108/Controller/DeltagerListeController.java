package no.hvl.dat108.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import no.hvl.dat108.InputValidator;
import no.hvl.dat108.Util.LoginUtil;

@Controller
public class DeltagerListeController {

	//get logut
	@GetMapping(value="/deltagerliste")
	public String loggUt() {
		return "logginn"; //jsp filnavnet
	}
	
	@PostMapping(value="/deltagerliste")
	public String loggetUt(HttpSession session) {
		
		session.invalidate();
		return "redirect:innlogging"; //URL
	}
	
}
