package no.hvl.dat108.Util;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.List;
import no.hvl.dat108.Deltager;


public class LoginUtil {
	
	public static void loggUtBruker(HttpSession session) {
		session.invalidate();
	}

	public static void loggInnBruker(HttpServletRequest request, Deltager deltager) {

		//Invalidere den gamle sesjonen
		loggUtBruker(request.getSession());
		//Opprette ein sesjon
		HttpSession sesjon = request.getSession();
		//Setter ein tid i sekunder til du blir logget ut
		sesjon.setMaxInactiveInterval(600);
		sesjon.setAttribute("bruker", deltager);
	}
	
	public static boolean erBrukerInnlogget(HttpSession session) {
		
		//Det må være ein sesjon, sendt med ein sesjonid parameter
		return session != null 
				&& session.getAttribute("bruker")!= null;
	}
	public static boolean sjekkMobil(List<Deltager> deltagere, String mobil) {
		if (mobil == null || mobil.trim()
		                          .isEmpty()) {
			return false;
		}
		if (deltagere == null || deltagere.isEmpty()) {
			return false;
		}
		return deltagere.stream()
		                .anyMatch(d -> d.getMobil()
		                                .equals(mobil));
	}

}
