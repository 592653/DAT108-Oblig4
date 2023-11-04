package no.hvl.dat108;

import java...

public class Deltager {
	
	@Notnull(message = "Feltet kan ikkje være tomt")
	@Size(min=2, max = 20, message = "Må være mellom 2 og 20 karakterer")
	private String fornavn;
	private String etternavn;
//	@Notnull...
//	navn
//	String hash
//	String salt
//	mobil
//	Her må vi ha med flere

	//passord inni herS
	
	public Deltager() {
		
	}
	
	public Deltager(String navn, String hash, mobil) {
		this.navn = navn;
	}
}
