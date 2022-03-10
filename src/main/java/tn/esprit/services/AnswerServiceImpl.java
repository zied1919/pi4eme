package tn.esprit.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.entities.Answer;
import tn.esprit.entities.User;
import tn.esprit.repositories.AnsewRepo;
import tn.esprit.repositories.UserRepo;

import javax.mail.MessagingException;
import java.util.List;
@Service

public class AnswerServiceImpl implements IntAnswer {
    @Autowired
    AnsewRepo ansewRepo;
    @Autowired
    UserRepo userRepo;


    @Override
    public void addAnswer(Answer a) {
        ansewRepo.save(a);

    }

    @Override
    public List<Answer> getAllAnswer() {
        return ansewRepo.findAll();
    }

    @Override
    public void updateAnswer(Answer a) {
        ansewRepo.save(a);
    }

    @Override
    public void deleteAnswer(int id) {
        ansewRepo.deleteById(id);

    }
    @Override
    public void addAnswerToUser( int idUser,int idAnswer) {
        User u= userRepo.findById(idUser).orElse(null);
        Answer a= ansewRepo.findById(idAnswer).orElse(null);
        a.getUsers().add(u);
    }

    @Override
    public int calculScoreQuiz(int idUser, int idQuiz) {
        int score= ansewRepo.calculScoreQuiz(idUser, idQuiz);

        return score;
    }
}
