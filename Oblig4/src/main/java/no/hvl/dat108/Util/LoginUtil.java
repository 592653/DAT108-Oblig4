package no.hvl.dat108.Util;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.List;
import no.hvl.dat108.Deltager;

public class LoginUtil {

	public static void loggInnBruker(HttpServletRequest request, Deltager deltager) {

		// Invalidere den gamle sesjonen
		loggUtBruker(request.getSession());
		// Opprette ein sesjon
		HttpSession session = request.getSession();
		// Setter ein tid i sekunder til du blir logget ut
		session.setMaxInactiveInterval(1200);
		session.setAttribute("Id", deltager.getMobil());
	}

	public static boolean erBrukerInnlogget(HttpSession session) {

		// Det må være ein sesjon, sendt med ein sesjonid parameter
		return session != null && session.getAttribute("Id") != null;
	}

	public static String getBrukerId(HttpSession session) {
		return (String) session.getAttribute("Id");
	}

	public static void loggUtBruker(HttpSession session) {
		session.invalidate();
	}

}
