package tn.esprit.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import tn.esprit.entities.Quizz;
import tn.esprit.services.IntQuizz;

import java.util.List;

@RestController
@RequestMapping

public class QuizzController {
    @Autowired
    IntQuizz intQuizz;
    @PostMapping("/Post")
    public void addQuizz(Quizz a){
        intQuizz.addQuizz(a);
    }
    @PutMapping("/Put")
    public void updateQuizz(Quizz a){
        intQuizz.updateQuizz(a);
    }
    @GetMapping("/Get")
    public List<Quizz> getAllQuizz(){
       return   intQuizz.getAllQuizz();
    }
    @DeleteMapping("/Delete/{id}")
    public void deleteQuizz(@PathVariable("id") int id){
        intQuizz.deleteQuizz(id);
    }


}
