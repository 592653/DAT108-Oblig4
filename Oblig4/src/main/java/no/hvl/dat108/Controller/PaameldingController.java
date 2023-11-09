package no.hvl.dat108.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import no.hvl.dat108.*;
import no.hvl.dat108.Util.LoginUtil;


@Controller
@RequestMapping("/paamelding")
public class PaameldingController {
	
	@Autowired
	private DeltagerRepository repo;

	//@GetMapping bruker ber om å melde seg på viewet
	@GetMapping //treng vi model model?
	public String paameldingsbekreftelse(HttpSession session) {
		return "paamelding"; //navnet på jsp filen
	}
	//@PostMapping Bruker har meldt seg på
	//redirekte til pameldingsbekreftelse
	@PostMapping
	public String getPaameldingsbekreftelse(
			@ModelAttribute DeltagerSkjema skjema,  
			HttpServletRequest request,
			RedirectAttributes ra) {
		
		// check if form is valid
		if (!InputValidator.gyldigFornavn(skjema.getFornavn())) {
			ra.addFlashAttribute("error", "Ugyldig fornavn");
			return "redirect:/paamelding";
		}
		
		if (!InputValidator.gyldigEtternavn(skjema.getEtternavn())) {
			ra.addFlashAttribute("error", "Ugyldig etternavn");
			return "redirect:/paamelding";
		}
		
		if (!InputValidator.gyldigMobil(skjema.getMobil())) {
			ra.addFlashAttribute("error", "Ugyldig mobilnummer");
			return "redirect:/paamelding";
		}
		
		if (!InputValidator.gyldigPassord(skjema.getPassord())) {
			ra.addFlashAttribute("error", "Ugyldig passord");
			return "redirect:/paamelding";
		}
		
		if (!skjema.getPassord().equals(skjema.getPassordRepetert())) {
			ra.addFlashAttribute("error", "Passordet passer ikkje");
			return "redirect:/paamelding";
		}
		
		if (repo.existsById(skjema.getMobil())) {
			ra.addFlashAttribute("error", "Mobilnummeret er allerede i bruk");
			return "redirect:/paamelding";
		}
		
		// save user details
		Deltager deltager = new Deltager();
		deltager.setFornavn(skjema.getFornavn());
		deltager.setEtternavn(skjema.getEtternavn());
		deltager.setMobil(skjema.getMobil());
		deltager.setKjonn(skjema.getKjonn());
		
		PassordService service = new PassordService();
		String salt = service.genererTilfeldigSalt();
		String hash = service.hashMedSalt(skjema.getPassord(), salt);
		
		deltager.setHash(hash);
		deltager.setSalt(salt);
		
		// register user
		repo.save(deltager);
		
		LoginUtil.loggInnBruker(request, deltager);
		
		return "redirect:paameldt";
	}
	
	
}

