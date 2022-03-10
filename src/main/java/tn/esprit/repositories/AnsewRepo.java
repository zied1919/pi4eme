package tn.esprit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.entities.Answer;

@Repository
public interface AnsewRepo extends JpaRepository<Answer,Integer> {
    @Query("select SUM (a.question.score) from Answer a join a.users u where u.id=:idUser and a.question.quizz.id=:idQuiz and a.resptrue=true ")
    public int calculScoreQuiz(@Param("idUser") int idUser,@Param("idQuiz") int idQuiz);

}
