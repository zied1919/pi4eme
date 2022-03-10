package tn.esprit.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.entities.swear_words;
import tn.esprit.services.SwearService;




@RestController
@RequestMapping("/Swear")
public class SwearController {

	@Autowired
	SwearService Os;
	@PostMapping("/addswear") 
	void add(@RequestBody swear_words f)
	{
		Os.addSwears(f);
	}
	
	@DeleteMapping("/deleteswear/{id}")
	void delete(@PathVariable("id") int id)
	{
		Os.deleteSwear(id);
	}

	@GetMapping("/displayswear")
	List<String> display()
	{
		return Os.listswears();
	}
		
	}
	