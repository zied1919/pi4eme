package tn.esprit.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.entities.Comment;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long>{
	
	
	
	@Query(value="select count(*) from liked l where l.etat = 1 and l.comment_id = ?1",nativeQuery=true)
	int countlike(long id);
	@Query(value="select count(*) from liked l where l.etat = -1 and l.comment_id = ?1",nativeQuery=true)
	int countdislike(long id);
	@Query(value="select * from comment c where c.forum_id = ?1",nativeQuery=true)
	List<Comment> retrivebyforum(long id);
/*
	 
 	Comment	findOneByContenu(String contenu);
 	List<Comment> findByContenu(String contenu);
	
	
	@Query(value="select * from comment c where c.contenu = ?1",nativeQuery=true)
	List<Comment> x(String contenu);
	@Query(value="select * from comment c where c.contenu = y",nativeQuery=true)
	List<Comment> x(@Param("c")String contenu);
	
	@Modifying
	//All methods except select
	 
	  
	  
	  
	  
	 

//	JPQL
	@Query("select r from Comment c where c.contenu = :contenu")
	Comment x(String contenu);
*/
	

}
