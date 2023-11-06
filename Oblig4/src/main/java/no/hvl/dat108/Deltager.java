package no.hvl.dat108;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import static no.hvl.dat108.InputValidator.*;

@Entity
@Table(name = "deltager", schema = "DAT108_oblig4")
public class Deltager {
	
	//lov med bindestrek og mellomrom
	//Første tegn må være ein stor bokstav
	@Pattern(regexp="^"+ ANY_LETTER +"$")
	@NotNull(message = "Feltet kan ikkje være tomt")
	@Size(min=2, max = 20, message = "Må være mellom 2 og 20 karakterer")
	@Column(name = "fornavn", length = 40)
	private String fornavn;
	
	//lov med bindestrek men ikkje mellomrom
	//Første tegn må være ein stor bokstav
	@Pattern(regexp="^"+ ANY_LETTER +"$")
	@NotNull(message = "Feltet kan ikkje være tomt")
	@NotBlank(message = "Kan ikkje inneholde mellomrom")
	@Size(min=2, max = 20, message = "Må være mellom 2 og 20 karakterer")
	@Column(name = "etternavn", length = 40)
	private String etternavn;
	
	@Id //pga brukenavn og er unikt
	@NotNull(message = "Feltet kan ikkje være tomt")
	@Pattern(regexp="^"+EIGHT_DIGIT_LONG+"$") //Lagd selv, er det rett?
	@Size(min=8, max=8, message = "Må være nøyaktig 8 sifre")
	@Column(name = "mobil", length = 8)
	private String mobil;
	
	@NotNull(message = "Feltet kan ikkje være tomt")
	@Min(value=2, message = "Må innholde minst seks tegn")
	@Pattern(regexp="^"+ SIX_OR_MORE_TIMES+"$")
	@Pattern(regexp="^"+ ANY_LETTER_OR_DIGIT+"$")
	private String passord;
	
	//må være likt som passord
	@NotNull(message = "Feltet kan ikkje være tomt")
	private String repetertPassord;
	
	@NotNull(message = "Kjonn er obligatorisk")
	@Pattern(regexp="^"+ MAN_OR_WOMAN +"$")
	@Column(name = "kjonn", length = 6)
	private String kjonn;
	
	@NotNull(message = "obligatorisk")
	@Column(name = "salt", length = 32)
	private String salt;
	
	@NotNull(message = "obligatorisk")
	@Column(name = "hash", length = 64)
	private String hash;
	

	public Deltager() { //Konstruktør
		
	}
	
	public Deltager(String fornavn, String etternavn, String mobil, String passord, String repetertPassord, String kjonn, String salt) {
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.mobil = mobil;
		this.passord = passord;
		this.repetertPassord = repetertPassord;
		this.kjonn = kjonn;
		this.salt = salt;
	}

	public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public String getMobil() {
		return mobil;
	}

	public void setMobil(String mobil) {
		this.mobil = mobil;
	}

	public String getPassord() {
		return passord;
	}

	public void setPassord(String passord) {
		this.passord = passord;
	}

	public String getRepetertPassord() {
		return repetertPassord;
	}

	public void setRepetertPassord(String repetertPassord) {
		this.repetertPassord = repetertPassord;
	}

	public String getKjonn() {
		return kjonn;
	}

	public void setKjonn(String kjonn) {
		this.kjonn = kjonn;
	}
	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}
	
	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}
	@Override
	public String toString() {
		return fornavn + "\n" + etternavn + "\n" + mobil + "\n" + kjonn;
	}
	
}
