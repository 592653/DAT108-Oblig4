package no.hvl.dat108.Controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/paameldt") //URL nettstedet
public class PaameldtController {

	@GetMapping
	public String HentDeltageliste() {
		return "deltagerliste";
	}
	@PostMapping
	public String deltakerListe(HttpSession session) {
		
		//if()
		//Sjekk om innlogget, sjekke om session er validert
		return "redirect:deltakerliste";  //jsp filen
	}
}
