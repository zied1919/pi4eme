package tn.esprit.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.entities.Question;
import tn.esprit.repositories.QuestionRepo;

import java.util.List;

@Service

public class QuestionServiceImpl implements IntQuestion {
    @Autowired
    QuestionRepo questionRepo;

    @Override
    public void addQuestion(Question a) {
        questionRepo.save(a);
    }

    @Override
    public List<Question> getAllQuestion() {
        return questionRepo.findAll();
    }

    @Override
    public void updateQuestion(Question a) {
        questionRepo.save(a);

    }

    @Override
    public void deleteQuestion(int id) {
        questionRepo.deleteById(id);
    }
}
