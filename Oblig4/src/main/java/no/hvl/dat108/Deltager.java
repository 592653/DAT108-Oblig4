package no.hvl.dat108;

import jakarta.validation.constraints.*;
import static no.hvl.dat108.InputValidator.*;

public class Deltager {
	
	//lov med bindestrek og mellomrom
	//Første tegn må være ein stor bokstav
	@Pattern(regexp="^"+ ANY_LETTER +"$")
	@NotNull(message = "Feltet kan ikkje være tomt")
	@Size(min=2, max = 20, message = "Må være mellom 2 og 20 karakterer")
	private String fornavn;
	
	//lov med bindestrek men ikkje mellomrom
	//Første tegn må være ein stor bokstav
	@Pattern(regexp="^"+ ANY_LETTER +"$")
	@NotNull(message = "Feltet kan ikkje være tomt")
	@NotBlank(message = "Kan ikkje inneholde mellomrom")
	@Size(min=2, max = 20, message = "Må være mellom 2 og 20 karakterer")
	private String etternavn;
	
	@NotNull(message = "Feltet kan ikkje være tomt")
	//@Unique det må være unikt, altså ikke registert før
	@Pattern(regexp="^"+EIGHT_DIGIT_LONG+"$") //Lagd selv, er det rett?
	@Size(min=8, max=8, message = "Må være nøyaktig 8 sifre")
	private String mobil;
	
	@NotNull(message = "Feltet kan ikkje være tomt")
	@Min(value=2, message = "Må innholde minst seks tegn")
	@Pattern(regexp="^"+ SIX_OR_MORE_TIMES+"$")
	@Pattern(regexp="^"+ ANY_LETTER_OR_DIGIT+"$")
	private String passord;
	
	//må være likt som passord
	@NotNull(message = "Feltet kan ikkje være tomt")
	private String repetertPassord;
	
	@NotNull(message = "Feltet kan ikkje være tomt")
	private Kjonn kjonn;
	
	public Deltager() { //Konstruktør
		
	}
	
	public Deltager(String fornavn, String etternavn, String mobil, String passord, String repetertPassord, Kjonn kjonn) {
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.mobil = mobil;
		this.passord = passord;
		this.repetertPassord = repetertPassord;
		this.kjonn = kjonn;
	}
	
	
}
