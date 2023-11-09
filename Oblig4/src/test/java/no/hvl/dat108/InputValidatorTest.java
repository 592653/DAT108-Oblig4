package no.hvl.dat108;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import jakarta.validation.Validation;
import jakarta.validation.Validator;

public class InputValidatorTest {


	@Test
	void validatePhone() {
		
		assertTrue(InputValidator.gyldigMobil("88888888"));
		assertTrue(InputValidator.gyldigMobil("47856985"));
		assertTrue(InputValidator.gyldigMobil("00000000"));
		
		assertFalse(InputValidator.gyldigMobil(""));
		assertFalse(InputValidator.gyldigMobil(" "));
		assertFalse(InputValidator.gyldigMobil("5 5"));
		assertFalse(InputValidator.gyldigMobil("787878"));
		assertFalse(InputValidator.gyldigMobil("7878787o"));
	}
	
	@Test
	void validateFirstName() {
		
		assertTrue(InputValidator.gyldigFornavn("Anne"));
		assertTrue(InputValidator.gyldigFornavn("MercuryPluto"));
		
		assertFalse(InputValidator.gyldigFornavn("A"));
		assertFalse(InputValidator.gyldigFornavn("Anneanneanneanneanneanneanneannneeeeeeeannnenenenenennnneeeeee"));
		assertFalse(InputValidator.gyldigFornavn("Ann!"));
	}
	
	@Test
	void validateLastName() {
		
		assertTrue(InputValidator.gyldigEtternavn("Anne"));
		assertTrue(InputValidator.gyldigEtternavn("Potatø"));
		
		assertFalse(InputValidator.gyldigEtternavn("A"));
		assertFalse(InputValidator.gyldigEtternavn("Anneanneanneanneanneanneannneennnenenenenenenenenenenene"));
	}
	
	@Test
	void validatePassword() {
		
		assertTrue(InputValidator.gyldigPassord("passord"));
		assertTrue(InputValidator.gyldigPassord("Passord"));
		assertTrue(InputValidator.gyldigPassord("Passord1234"));
		
		assertFalse(InputValidator.gyldigPassord("P"));
		assertFalse(InputValidator.gyldigPassord("pas"));
	}
}
