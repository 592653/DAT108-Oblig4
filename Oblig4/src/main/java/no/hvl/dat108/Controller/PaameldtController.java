package no.hvl.dat108.Controller;

import jakarta.servlet.http.HttpSession;
import no.hvl.dat108.Deltager;
import no.hvl.dat108.DeltagerRepository;
import no.hvl.dat108.PaameldteService;
import no.hvl.dat108.PassordService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/paameldt") //URL nettstedet
public class PaameldtController {

	@Autowired
	private DeltagerRepository repo;
	
	@Autowired
	private PaameldteService paameldteService;

	@Autowired
	private PassordService passordService;
	
	@GetMapping
	public String HentDeltageliste() {
		return "deltagerliste";
	}
	@PostMapping
	public String deltakerListe(Model model, HttpSession session) {
		Deltager d = repo.findById((String)session.getAttribute("mobil")).get();
		model.addAttribute("fornavn", d.getFornavn());
		model.addAttribute("etternavn", d.getEtternavn());
		model.addAttribute("mobil", d.getMobil());
		//if()
		
		//Sjekk om innlogget, sjekke om session er validert
		return "redirect:deltakerliste";  //jsp filen
	}
}
