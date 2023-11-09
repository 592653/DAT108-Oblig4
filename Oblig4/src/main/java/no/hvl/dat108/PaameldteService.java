package no.hvl.dat108;

import no.hvl.dat108.Deltager;
import no.hvl.dat108.DeltagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * En service som holder styr på påmeldte.
 */
@Service
public class PaameldteService {

	private boolean first = true;

	public boolean isFirst() {
		return first;
	}

	public void setFirst(boolean first) {
		this.first = first;
	}

	/**
	 * Listen over påmeldte.
	 */
	private final List<Deltager> paameldte = new ArrayList<>();

	/**
	 * Legger til en deltager i listen over påmeldte.
	 *
	 * @param deltager Deltageren som skal legges til
	 */
	public void leggTilDeltager(Deltager deltager) {
		paameldte.add(deltager);
	}


	/**
	 * Henter listen over påmeldte.
	 *
	 * @return listen over påmeldte
	 */
	public List<Deltager> hentDeltagere() {
		return paameldte;
	}

	/**
	 * Sjekker om en deltager med gitt mobilnummer finnes i listen over påmeldte.
	 *
	 * @param mobil Mobilnummeret til deltageren som skal sjekkes
	 *
	 * @return Deltager om den finnes, ellers null
	 */
	public Deltager getDeltager(String mobil) {
		for (Deltager d : paameldte) {
			if (d.getMobil()
			     .equals(mobil)) {
				return d;
			}
		}
		return null;
	}
}