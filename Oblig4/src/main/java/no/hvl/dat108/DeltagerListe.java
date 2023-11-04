package no.hvl.dat108;

import java.util.ArrayList;

public class DeltagerListe {
	
	private int antall = 0;
	private ArrayList<Deltager> deltagere = new ArrayList<Deltager>();
	
	public void leggTil(Deltager deltager) {
		deltagere.add(deltager);
		antall++;
	}
}
