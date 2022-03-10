package tn.esprit.repositories;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.entities.Like;

@Repository
public interface LikeRepository extends CrudRepository<Like, Long>{
	@Query(value="select * from liked where userid = ?1 and comment_id = ?2",nativeQuery=true)
	Like findUser(long userid,long comment_id);
	//Like findOneByUserid(long id);
	@Query(value="select count(*) from liked where etat = 1 and comment_id = ?1",nativeQuery=true)
	int nblike(int id);
	@Query(value="select count(*) from liked where etat = -1 and comment_id = ?1",nativeQuery=true)
	int nbdislike(int id);
}
