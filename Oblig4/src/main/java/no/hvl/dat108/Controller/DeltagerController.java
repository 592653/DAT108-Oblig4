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
@RequestMapping("/paamelding")
public class DeltagerController {

	//@GetMapping bruker ber om å melde seg på viewet
	@GetMapping //treng vi model model?
	public String paameldt(HttpSession session) {
		System.err.println("Bekreftelse av: " + session.getAttribute("bekreftelse"));
		return "paamelding"; //navnet på jsp filen
	}
	//@PostMapping Bruker har meldt seg på
	//redirekte til pameldingsbekreftelse
	@PostMapping
	public String paameldtRe(HttpSession session) {
		return "redirect:paameldt"; //redirecte til paamelt
	}
	
}

