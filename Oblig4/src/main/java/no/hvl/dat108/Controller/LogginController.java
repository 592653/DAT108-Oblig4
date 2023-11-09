package no.hvl.dat108.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;
import no.hvl.dat108.Deltager;
import no.hvl.dat108.DeltagerRepository;
import no.hvl.dat108.InputValidator;
import no.hvl.dat108.PassordService;
import no.hvl.dat108.Util.*;

@Controller
@RequestMapping("/innlogging")
public class LogginController {

	@Autowired
	private PassordService passordService;

	@Autowired
	DeltagerRepository repo;
	// her trenger vi ein ny sesjon

	// get login er forespøsel om å få loginsiden
	@GetMapping
	public String hentLoginSkjema() {
		return "logginn"; // jsp filen
	}

	@PostMapping //Prøver å logge inn
	public String LoggeInn(@RequestParam String mobil, @RequestParam String passord, HttpServletRequest request,
			RedirectAttributes ra) {

		// validate brukernavn og passord

		if (!InputValidator.gyldigMobil(mobil)) {
			ra.addFlashAttribute("error", "Ukjent brukernavn");
			return "redirect:logginn";
		}

		if (!InputValidator.gyldigPassord(passord)) {
			ra.addFlashAttribute("error", "Feil passord");
			return "redirect:loginn";
		}

		//Sjekke at brukenavn og passord matcher

		Optional<Deltager> deltagerOptional = repo.findById(mobil);

		if (deltagerOptional.isPresent()) {

			Deltager deltager = deltagerOptional.get();
			PassordService service = new PassordService();

			// successful user login

			if (service.erKorrektPassord(passord, deltager.getSalt(), deltager.getHash())) {

				LoginUtil.loggInnBruker(request, deltager);
				return "redirect:deltagerliste";
			}
		}
		ra.addFlashAttribute("error", "Feil brukernavn eller passord");
		return "redirect:logginn";
	}

}
