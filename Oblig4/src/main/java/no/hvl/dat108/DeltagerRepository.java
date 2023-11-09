package no.hvl.dat108;

import org.springframework.data.repository.CrudRepository;

public interface DeltagerRepository extends CrudRepository<Deltager, String>{
	//Henter deltager ved iden mobil
	Deltager findByMobil(String mobil);
	
	//Sletter en deltager med gitt mobilnummer fra databasen
	void deleteDeltagerByMobil(String mobil);
}
