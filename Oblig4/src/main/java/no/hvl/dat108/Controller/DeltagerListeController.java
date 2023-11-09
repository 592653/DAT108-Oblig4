package no.hvl.dat108.Controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;
import no.hvl.dat108.Deltager;
import no.hvl.dat108.DeltagerRepository;
import no.hvl.dat108.Util.LoginUtil;

@Controller
@RequestMapping("/deltagerliste")
public class DeltagerListeController {
	
	@Autowired
	DeltagerRepository repo;
	
	@GetMapping
	public String getList(Model model, HttpSession session, RedirectAttributes ra) {
		
		//sjekke om bruker er logget inn
		if (!LoginUtil.erBrukerInnlogget(session)) {
			
			ra.addFlashAttribute("error", "Du må logge inn");
			return "redirect:logginn";
		}
		// find all users for list
		List <Deltager> list = repo.findAll();
		Collections.sort(list);
		model.addAttribute("AlleBrukere", list);
		
		Deltager deltager = repo.findById(LoginUtil.getBrukerId(session)).get();
		
		model.addAttribute("currentFornavn", deltager.getFornavn());
		model.addAttribute("currentEtternavn", deltager.getEtternavn());
		model.addAttribute("currentMobil", deltager.getMobil());

		return "deltagerliste";
	}
	
	// post - redirect to logging out
	@PostMapping
	public String loggUt(HttpSession session, RedirectAttributes ra) {
		LoginUtil.loggUtBruker(session);
		
		ra.addFlashAttribute("Error", "Du er logget ut");
		return "redirect:logginn";
	}
}
