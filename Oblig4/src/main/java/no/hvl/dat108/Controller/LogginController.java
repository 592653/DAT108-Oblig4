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
import jakarta.websocket.Session;
import no.hvl.dat108.Deltager;
import no.hvl.dat108.DeltagerRepository;
import no.hvl.dat108.InputValidator;
import no.hvl.dat108.PaameldteService;
import no.hvl.dat108.PassordService;
import no.hvl.dat108.Util.LoginUtil;

@Controller
@RequestMapping("/innlogging")
public class LogginController {
	
	@Autowired
	private PassordService passordService;

	@Autowired
	private PaameldteService paameldteService;

	@Autowired
	DeltagerRepository deltagerRepo;
	//her trenger vi ein ny sesjon
	
	//get login er forespøsel om å få loginsiden
	@GetMapping
	public String hentLoginSkjema(Model model) {
		return "logginn"; //jsp filen
	}
	@PostMapping
	public String provAaLoggeInn(@RequestParam String mobil, @RequestParam String passord, HttpServletRequest request, RedirectAttributes ra, HttpSession session) {
		
		if (LoginUtil.erBrukerInnlogget(request.getSession())) {
			return "redirect:deltagerliste";
		}
		Deltager deltager = deltagerRepo.findByMobil(mobil);
		if (deltager == null) {
			ra.addFlashAttribute("feilmelding", "Finner ikke bruker med dette mobilnummeret");
			ra.addFlashAttribute("mobil", mobil);
			return "redirect:login";
		}
		session.invalidate(); //fjerne den som er innlogget
		HttpSession sesjon = request.getSession(); //Ny sesjon
	    sesjon.setMaxInactiveInterval(500);
	    //Vi ønsker å bli logget ut etter 5 min elns
		
		if(!InputValidator.gyldigMobil(mobil)) {
			//Feilmelding og gå tilbake til logginsiden
			ra.addFlashAttribute("redirectMessage", "Ugyldig brukernavn");
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
		
		//Sjekker om deltager finnes
		if (!passordService.erKorrektPassord(passord, deltager.getSalt(), deltager.getHash())) {
			ra.addFlashAttribute("feilmelding", "Passord er feil");
			ra.addFlashAttribute("mobil", mobil);
			return "redirect:login";	
		}
	    LoginUtil.loggInnBruker(request, deltager);
		return "redirect:deltagerliste";
	}
	

}
