package tn.esprit.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.entities.Comment;
import tn.esprit.services.CommentService;
import tn.esprit.services.ForumService;

@RestController
@RequestMapping("/Comment")
public class CommentController {

	@Autowired
	CommentService Cs;
	@Autowired
	ForumService Fs;
	@PostMapping("/addcomment/{id}") 
	void add(@RequestBody Comment f,@PathVariable("id") int id)
	{
		if(Fs.swearAction(f.getContenu()) ==0) {
		f.setForum(Fs.retrieveForum(id));
		Cs.addComment(f);
		}
	}
	@PutMapping("/updatecomment")
	void update(@RequestBody Comment f)
	{
		Cs.updateComment(f);
	}
	@DeleteMapping("/deletecomment/{id}")
	void delete(@PathVariable("id") int id)
	{
		Cs.deleteComment(id);
	}
	@GetMapping("/displaycomment")
	List<Comment> display()
	{
		return Cs.retreiveAllComments();
	}
	@GetMapping("/find/{id}")
	Comment find(@PathVariable("id") int id)
	{
		return Cs.retrieveComment(id);
	}
	@GetMapping("/count/{id}")
	int count(@PathVariable("id") int id)
	{
		return Cs.countlikes(id);
	}
	@GetMapping("/viral/{id}")
	Comment viral(@PathVariable("id") long id)
	{
		return Cs.viral(id);
	}
	@GetMapping("/mosthated/{id}")
	Comment mosthated(@PathVariable("id") long id)
	{
		return Cs.mosthated(id);
	}
	}



