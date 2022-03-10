package tn.esprit.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.entities.Forum;

@Repository

public interface ForumRepository extends CrudRepository<Forum, Long>{

	@Query("select f from Forum f where f.contenu like %?1% or f.date like %?1%")
	List<Forum> search(String keyword);
//	List<Forum> findByContenuLikeOrDateLike(String contenu, String date);
	
	@Query("select word from swear_words")
	List<String> listSwear();

	@Query(value="select * from Forum f where f.id = ?1",nativeQuery=true)
	Forum findone(int id);
	
	@Query(value="select count(*) from Comment c where c.forum_id = ?1",nativeQuery=true)
	int nbcomment(int id);
	
	@Query(value="select * from forum where id IN (select f.id from forum f "
			+ "JOIN comment c ON f.id = c.forum_id\n"
			+ "JOIN liked l ON c.id = l.comment_id\n"
			+ "WHERE c.userid = ?1 OR l.userid = ?1)",nativeQuery=true)
	List<Forum> display(int id);
	
	@Query(value="select * from forum where id NOT IN (select f.id from forum f "
			+ "JOIN comment c ON f.id = c.forum_id\n"
			+ "JOIN liked l ON c.id = l.comment_id\n"
			+ "WHERE c.userid = ?1 OR l.userid = ?1)",nativeQuery=true)
	List<Forum> display2(int id);
	
	
	@Query(value="select forum_id, count(*) as ct  \n"
			+ "  from comment  \n"
			+ " group by forum_id  \n"
			+ " order by ct desc  \n"
			+ " limit 1; ",nativeQuery=true)
	long viral();
	/*

	@Query("SELECT f FROM Forum f WHERE f.comment = (SELECT MAX(c.nbLike) FROM Comment c WHERE f.comment = c )")
	Forum viral();
	
	
	
	@Query(value="SELECT * FROM forum a \n"
			+ "  JOIN comment b ON a.comment_id = b.id\n"
			+ "  JOIN forum c ON b.forum_id = c.id\n"
			+ "  WHERE a.etat = 1 and c.id = ?1",nativeQuery=true)
	int viral();
	
	
	SELECT count(*) FROM liked a 
  JOIN comment b ON a.comment_id = b.id
  JOIN forum c ON b.forum_id = c.id
WHERE a.etat = 1;

SELECT id, nom, MAX(prix) FROM produit

SELECT MAX(y.num)
  FROM (SELECT COUNT(*) AS num
          FROM TABLE comment c where ) y
*/
	
}
