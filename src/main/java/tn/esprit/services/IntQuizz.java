package tn.esprit.services;



import java.util.List;

import tn.esprit.entities.Quizz;

public interface IntQuizz {
    public void addQuizz(Quizz a);
    public List<Quizz> getAllQuizz();
    public void updateQuizz(Quizz a);
    public void deleteQuizz(int id);
}
