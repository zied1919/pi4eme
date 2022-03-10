package tn.esprit.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import tn.esprit.entities.Question;
import tn.esprit.services.IntQuestion;

import java.util.List;

@RestController

@RequestMapping("Question")

public class QuestionController {
    @Autowired
    IntQuestion intQuestion ;
    @PostMapping("/Post")
    public void addQuestion(Question a){
        intQuestion.addQuestion(a);
    }
    @GetMapping("/Get")
    public List<Question> getAllQuestion(){
       return intQuestion.getAllQuestion();
    }
    @PutMapping("/Put")
    public void updateQuestion(Question a){
        intQuestion.updateQuestion(a);
    }
    @DeleteMapping("/Delete/{id}")
    public void deleteQuestion(@PathVariable ("id") int id){
        intQuestion.deleteQuestion(id);
    }
}
