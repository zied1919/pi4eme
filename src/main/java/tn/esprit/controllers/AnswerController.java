package tn.esprit.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.itextpdf.text.DocumentException;

import tn.esprit.entities.Answer;
import tn.esprit.services.IPdfService;
import tn.esprit.services.IntAnswer;

import javax.mail.MessagingException;
import javax.transaction.Transactional;
import java.io.FileNotFoundException;
import java.util.List;

@RestController
@RequestMapping("Answer")
@Transactional
public class AnswerController {
    @Autowired
    IntAnswer intAnswer;
    @Autowired
    IPdfService iPdfService;

    @PostMapping("/Post")
    public void addAnswer(@RequestBody Answer a) {
        intAnswer.addAnswer(a);
    }
    @GetMapping("/Get")
    public List<Answer> getAllAnswer(){
        return intAnswer.getAllAnswer();
    }
    @PutMapping("/Put")
    public void updateAnswer(@RequestBody Answer a){
        intAnswer.updateAnswer(a);
    }
    @DeleteMapping("/Delete/{id}")
    public void deleteAnswer(@PathVariable("id") int id){
        intAnswer.deleteAnswer(id);
    }
    @PostMapping("/AddAnswerToUser/{idu}/{ida}")
    public void addAnswerToUser( @PathVariable("idu") int idUser,@PathVariable("ida") int idAnswer) {
        intAnswer.addAnswerToUser(idUser,idAnswer);
    }
    @GetMapping("/get/{idU}/{idQ}")
    public int calculScoreQuiz(@PathVariable("idU") int idUser,@PathVariable("idQ") int idQuiz) throws MessagingException {
        return intAnswer.calculScoreQuiz(idUser, idQuiz);
    }
    @GetMapping("/getPDF/{id}")
    public String toPDF(@PathVariable("id") int id) throws FileNotFoundException, DocumentException {

        return iPdfService.toPDF(id);
    }



}
