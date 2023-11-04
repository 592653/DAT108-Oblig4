package no.hvl.dat108.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpServletRequest;
import no.hvl.dat108.InputValidator;
import no.hvl.dat108.Util.LoginUtil;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	//her trenger vi ein ny sesjon
	
	//get login er forespøsel om å få loginsiden
	@GetMapping
	public String hentLoginSkjema() {
		return "loginView";
	}
	@PostMapping
	public String provAaLoggeInn(@RequestParam String username, HttpServletRequest request, RedirectAttributes ra) {
		
		if(!InputValidator.isValidUsername(username)) {
			//Feilmelding og gå tilbake til logginsiden
			ra.addFlashAttribute("redirectMessage", "Ugyldig brukernavn");
			//redirekt til logginsiden
			return "resirect:login";
			//ikkje navnet på viewet men navnet på url
		}
		LoginUtil.loggInnBruker(request, username);
		return "redirect:deltagerliste";
	}

}
