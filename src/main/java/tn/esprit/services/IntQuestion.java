package tn.esprit.services;



import java.util.List;

import tn.esprit.entities.Question;

public interface IntQuestion  {
    public void addQuestion(Question a);
    public List<Question> getAllQuestion();
    public void updateQuestion(Question a);
    public void deleteQuestion(int id);
}
