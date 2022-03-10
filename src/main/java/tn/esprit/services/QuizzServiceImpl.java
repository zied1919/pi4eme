package tn.esprit.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tn.esprit.entities.Quizz;
import tn.esprit.repositories.QuizzRepo;

import java.util.List;

@Repository

public class QuizzServiceImpl implements IntQuizz {
    @Autowired
    QuizzRepo quizzRepo;

    @Override
    public void addQuizz(Quizz a) {
        quizzRepo.save(a);
    }

    @Override
    public List<Quizz> getAllQuizz() {
        return quizzRepo.findAll();
    }

    @Override
    public void updateQuizz(Quizz a) {
        quizzRepo.save(a);
    }

    @Override
    public void deleteQuizz(int id) {
        quizzRepo.deleteById(id);
    }
}
