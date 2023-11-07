package no.hvl.dat108.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;
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
	public String provAaLoggeInn(@RequestParam String mobil, @RequestParam String passord, HttpServletRequest request, RedirectAttributes ra, HttpSession session) {
		
		HttpSession sesjon = request.getSession();
		session.invalidate(); //fjerne den som er innlogget
	    HttpSession newSession = request.getSession(); // create session
	    sesjon.setMaxInactiveInterval(500);
	    //Vi ønsker å bli logget ut etter 5 min elns
		
		if(!InputValidator.gyldigMobil(mobil) || !InputValidator.gyldigPassord(passord)) {
			//Feilmelding og gå tilbake til logginsiden
			ra.addFlashAttribute("redirectMessage", "Ugyldig brukernavn eller passord");
			return "redirect:innlogging";
			//ikkje navnet på viewet men navnet på url
		}
		//Invalidere den gamle sesjonen
				//loggUtBruker(request.getSession());
				//Opprette ein sesjon
				//HttpSession sesjon = request.getSession();
				//Setter ein tid i sekunder til du blir logget ut
				//sesjon.setMaxInactiveInterval(500);
				//sesjon.setAttribute("username", username);
				
		
	    LoginUtil.loggInnBruker(request, mobil);
		return "redirect:deltagerliste";
	}
	

}
