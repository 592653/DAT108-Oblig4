package no.hvl.dat108.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import no.hvl.dat108.Deltager;
import no.hvl.dat108.DeltagerRepository;
import no.hvl.dat108.InputValidator;
import no.hvl.dat108.Util.LoginUtil;

@Controller
@RequestMapping("/paamelding")
public class PaameldingController {
	
	@Autowired
	private DeltagerRepository repo;

	//@GetMapping bruker ber om å melde seg på viewet
	@GetMapping //treng vi model model?
	public String paameldingsbekreftelse(HttpSession session) {
		//System.err.println("Bekreftelse av: " + session.getAttribute("bekreftelse"));
		return "paameldt"; //navnet på jsp filen
	}
	//@PostMapping Bruker har meldt seg på
	//redirekte til pameldingsbekreftelse
	@PostMapping
	public String getPaameldingsbekreftelse(Model model, HttpSession session) {
//			Model model, @RequestParam Deltager deltager, @RequestParam String mobil, HttpSession session) {
    	Deltager d = repo.findById((String)session.getAttribute("mobil")).get();
		
		model.addAttribute("fornavn", d.getFornavn());
    	model.addAttribute("etternavn", d.getEtternavn());
    	model.addAttribute("mobil", d.getMobil());
    	model.addAttribute("Kjonn", d.getKjonn());
//		session.setAttribute("brukernavn", mobil); //setter mobil som brukernavn
		return "redirect:paameldt"; //redirecte til paamelt url
	}
	
	
	
}

