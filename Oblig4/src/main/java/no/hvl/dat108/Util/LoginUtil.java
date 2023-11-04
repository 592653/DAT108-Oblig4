package no.hvl.dat108.Util;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class LoginUtil {
	public static void loggUtBruker(HttpSession session) {
	}

	public static void loggInnBruker(HttpServletRequest request, String username) {

		//Invalidere den gamle sesjonen
		loggUtBruker(request.getSession());
		//Opprette ein sesjon
		HttpSession sesjon = request.getSession();
		//Setter ein tid i sekunder til du blir logget ut
		sesjon.setMaxInactiveInterval(500);
		sesjon.setAttribute("username", username);
		

	}
	
	public static boolean erBrukerInnlogget(HttpSession session) {
		
		//Det må være ein sesjon, sendt med ein sesjonid parameter
		
		
		return session != null 
				&& session.getAttribute("username")!= null
                && session.getAttribute("cart")!= null;
	}

}
