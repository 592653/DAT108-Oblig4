package no.hvl.dat108.Controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PaameldtController {

	@GetMapping(value="/paameldt")
	public String HentDeltageliste() {
		return "deltagerliste";
	}
	@PostMapping(value="/paameldt")
	public String deltakerListe(HttpSession session) {
		return "redirect:deltakerliste";
	}
}
