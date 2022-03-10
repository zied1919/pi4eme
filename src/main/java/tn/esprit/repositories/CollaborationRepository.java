package tn.esprit.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.entities.Collaboration;


@Repository
public interface CollaborationRepository extends CrudRepository<Collaboration, Long>{

}
