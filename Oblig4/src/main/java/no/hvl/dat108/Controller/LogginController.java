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
@RequestMapping("/innlogging")
public class LogginController {
	
	//her trenger vi ein ny sesjon
	
	//get login er forespøsel om å få loginsiden
	@GetMapping
	public String hentLoginSkjema() {
		return "logginn"; //jsp filen
	}
	@PostMapping
	public String provAaLoggeInn(@RequestParam String fornavn, HttpServletRequest request, RedirectAttributes ra) {
		
		if(!InputValidator.gyldigFornavn(fornavn)) {
			//Feilmelding og gå tilbake til logginsiden
			ra.addFlashAttribute("redirectMessage", "Ugyldig fornavn");
			//redirekt til logginsiden
			return "redirect:innlogging";
			//ikkje navnet på viewet men navnet på url
		}
		LoginUtil.loggInnBruker(request, fornavn);
		return "redirect:deltagerliste";
	}

}
