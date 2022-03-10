package tn.esprit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.entities.Question;

@Repository

public interface QuestionRepo extends JpaRepository<Question,Integer> {
}
