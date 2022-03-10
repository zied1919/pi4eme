package tn.esprit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.entities.Quizz;

@Repository

public interface QuizzRepo extends JpaRepository<Quizz,Integer> {
}
