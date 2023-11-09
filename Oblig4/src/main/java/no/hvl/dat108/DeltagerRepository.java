package no.hvl.dat108;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface DeltagerRepository extends CrudRepository<Deltager, String>{
	//Henter deltager ved iden mobil
	List<Deltager> findAll();
}
