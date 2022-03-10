package tn.esprit.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.entities.Like;
import tn.esprit.services.CommentService;
import tn.esprit.services.LikeService;


	@RestController
	@RequestMapping("/Like")
	public class LikeController {
    
		@Autowired
		LikeService Ls;
		@Autowired
		CommentService Cs;

		@PostMapping("/addlike/{id}") 
		void add(@RequestBody Like f,@PathVariable("id") int id)
		{
			Like l= new Like();
			l=Ls.retrieveUser(f,id);
			f.setComment(Cs.retrieveComment(id));
			
			if(l == null) {
				Ls.addLike(f);
			}
			else if(l.getEtat()==f.getEtat()) {
				Ls.deleteLike(l.getId());
			}
			else {
				Ls.deleteLike(l.getId());
				Ls.addLike(f);
			}
		}
		
		@GetMapping("/displaylike")
		List<Like> display()
		{
			return Ls.retreiveAllLikes();
		}

		@GetMapping("/count/{id}")
		String count(@PathVariable("id") int id)
		{
			return Ls.nblike(id);
		}
		}

