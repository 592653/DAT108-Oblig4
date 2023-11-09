package no.hvl.dat108;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import static no.hvl.dat108.InputValidator.*;

@Entity
@Table(name = "deltager", schema = "DAT108_oblig4")
public class Deltager implements Comparable<Deltager> {

	// lov med bindestrek og mellomrom
	// Første tegn må være ein stor bokstav
	//@Pattern(regexp = "^" + ANY_LETTER + "$")
	@NotNull(message = "Feltet kan ikkje være tomt")
	@Size(min = 2, max = 20, message = "Må være mellom 2 og 20 karakterer")
	@Column(name = "fornavn", length = 40)
	private String fornavn;

	// lov med bindestrek men ikkje mellomrom
	// Første tegn må være ein stor bokstav
	//@Pattern(regexp = "^" + ANY_LETTER + "$")
	@NotNull(message = "Feltet kan ikkje være tomt")
	@NotBlank(message = "Kan ikkje inneholde mellomrom")
	@Size(min = 2, max = 20, message = "Må være mellom 2 og 20 karakterer")
	@Column(name = "etternavn", length = 40)
	private String etternavn;

	@Id // pga brukenavn og er unikt
	@NotNull(message = "Feltet kan ikkje være tomt")
	
	@Size(min = 8, max = 8, message = "Må være nøyaktig 8 sifre")
	@Column(name = "mobil", length = 8)
	private String mobil;

	@NotNull(message = "Kjonn er obligatorisk")
	@Column(name = "kjonn", length = 6)
	private String kjonn;

	@NotNull(message = "obligatorisk")
	@Column(name = "salt", length = 32)
	private String salt;

	@NotNull(message = "obligatorisk")
	@Column(name = "hash", length = 64)
	private String hash;

	public Deltager() { // Konstruktør

	}

	public Deltager(String fornavn, String etternavn, String mobil,
			String kjonn, String salt) {
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.mobil = mobil;
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
	public int compareTo(Deltager d) {

		int result = getFornavn().compareTo(d.getFornavn());

		if (result == 0) {

			result = getEtternavn().compareTo(d.getEtternavn());
		}

		return result;
	}

}
