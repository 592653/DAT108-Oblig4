package no.hvl.dat108;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import no.hvl.dat108.Controller.PaameldingController;

@ExtendWith(MockitoExtension.class)
public class PaameldingControllerTest {
	
	@Mock
	DeltagerRepository repo;
	
	@InjectMocks
	PaameldingController mockController;

	@Test
	public void registerParticipant() {
		
		DeltagerSkjema skjema = new DeltagerSkjema();
		MockHttpServletRequest mockRequest = new MockHttpServletRequest();
		RedirectAttributes ra = new RedirectAttributesModelMap();
				
	    skjema.setFornavn("Ingrid");
		skjema.setEtternavn("Olsen");
		skjema.setMobil("11112222");
		skjema.setPassord("hello123");
		skjema.setPassordRepetert("hello123");
		skjema.setKjonn("kvinne");
		
		assertEquals(mockController.getPaameldingsbekreftelse(skjema, mockRequest, ra), "redirect:paameldt");
		
	}
	
	@Test
	public void failToRegisterParticipant() {
		
		DeltagerSkjema skjema = new DeltagerSkjema();
		MockHttpServletRequest mockRequest = new MockHttpServletRequest();
		RedirectAttributes ra = new RedirectAttributesModelMap();
				
		assertEquals(mockController.getPaameldingsbekreftelse(skjema, mockRequest, ra), "redirect:/paamelding");
	}
}
