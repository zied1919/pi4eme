package tn.esprit.services;


import org.springframework.web.bind.annotation.PutMapping;

import tn.esprit.entities.Answer;

import javax.mail.MessagingException;
import java.util.List;

public interface IntAnswer {
    public void addAnswer(Answer a);
    public List<Answer> getAllAnswer();
    public void updateAnswer(Answer a);
    public void deleteAnswer(int id);
    public void addAnswerToUser( int idUser,int idAnswer);
    public int calculScoreQuiz( int idUser,int idQuiz) throws MessagingException;


}
