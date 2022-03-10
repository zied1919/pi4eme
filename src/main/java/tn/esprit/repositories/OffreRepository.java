package tn.esprit.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.entities.Offre;

@Repository
public interface OffreRepository extends CrudRepository<Offre, Long>{

	@Query(value="select count(*) from offre o where o.start_date > cast((now()) as date) and o.collaboration_id = ?1",nativeQuery=true)
	int notstarted(int id);
	@Query(value="select count(*) from offre o where o.end_date < cast((now()) as date) and o.collaboration_id = ?1",nativeQuery=true)
	int finished(int id);
	@Query(value="select count(*) from offre o "
			+ "where o.start_date < cast((now()) as date) "
			+ "and o.end_date > cast((now()) as date) and o.collaboration_id = ?1",nativeQuery=true)
	int inprogress(int id);
	@Query(value="select count(*) from offre o where o.collaboration_id = ?1",nativeQuery=true)
	int total(int id);
}
