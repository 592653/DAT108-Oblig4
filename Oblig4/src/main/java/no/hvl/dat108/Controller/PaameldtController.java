package no.hvl.dat108.Controller;

import jakarta.servlet.http.HttpSession;
import no.hvl.dat108.*;
import no.hvl.dat108.Util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/paameldt") // URL nettstedet
public class PaameldtController {

	@Autowired
	private DeltagerRepository repo;

	@GetMapping
	public String Deltageliste(Model model, HttpSession session, RedirectAttributes ra) {

		if (!LoginUtil.erBrukerInnlogget(session)) {

			ra.addFlashAttribute("error", "You need to be logged in");
			return "redirect:logginn";
		}

		// get new user

		Deltager d = repo.findById(LoginUtil.getBrukerId(session)).get();

		model.addAttribute("Fornavn", d.getFornavn());
		model.addAttribute("Etternavn", d.getEtternavn());
		model.addAttribute("Mobil", d.getMobil());
		model.addAttribute("Kjonn", d.getKjonn());
		return "paameldt"; // jsp filen
	}
	@PostMapping
	public String getDeltgerliste() {
		return "redirect:deltagerliste";
	}
}
