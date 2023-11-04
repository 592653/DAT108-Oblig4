package no.hvl.dat108;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ApplicationTests {

//Testkrav:
//Skal inneholde minimum 5 ulike "asserts" tester
//Noe av inputvalideringen ved påmelding (deklarativ / programmatisk)
//Hjelpeklasser, f.eks. for håndtering av pålogging / autentisering
//Service-klasser som behandler data inn/ut mellom Controller og Repository
//Feilhåndtering i Controllere?	
	@Test
	void valiedUsername() {
		assertTrue(InputValidator.isValidUsername(null))
	
	}
	 @Test
	 public void ...() {
		 assertFalse("AA", " ", )
       assertFalse()
     }
	@Test
	public String rettPassord() {
		assertEquals(passord, hash + salt);
	
	}
	 
	@ParameterizedTest
	@ValueSource(strings = {"", "A", "Hans Hansen", "Lars-P"})
	public void ugyldigeNavn(String navnFraListe) {
		
		// Denne testen blir kjørt (i en løkke) for alle navn 
		// listet opp i ValueSource.
		Deltager deltager = new Deltager(navnFraListe, 1970);
		assertFalse(erGyldigEgenskap(deltager, "navn"));
	}

//	   @Test
//	   public void dfsf() {
//	        assertEquals(0, Skattekalkulator.beregnSkatt(0)); 
//	        assertEquals(0, Skattekalkulator.beregnSkatt(0));
//	   }
	private boolean erGyldigEgenskap(Deltager deltager, String egenskap) {
		
		return !validator.validate(deltager).stream()			//Strøm av alle feil (objekter)
				.map(v -> v.getPropertyPath().toString())	//Strøm av alle egenskaper med feil
				.collect(Collectors.toSet())				//Samlet opp i et Set av egenskaper med feil
				.contains(egenskap);						//Om den egenskapen vi lurer på har feil
	}
}
