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

import tn.esprit.entities.Offre;
import tn.esprit.services.CollaborationService;
import tn.esprit.services.OffreService;


	@RestController
	@RequestMapping("/Offre")
	public class OffreController {




		
		@Autowired
		OffreService Os;
		@Autowired
		CollaborationService Cs;
		@PostMapping("/addoffre/{id}") 
		void add(@RequestBody Offre f,@PathVariable("id") int id)
		{
			f.setCollaboration(Cs.retrieveCollaboration(id));
			Os.addOffre(f);
		}
		@PutMapping("/updateoffre")
		void update(@RequestBody Offre f)
		{
			Os.updateOffre(f);
		}
		@DeleteMapping("/deleteoffre/{id}")
		void delete(@PathVariable("id") int id)
		{
			Os.deleteOffre(id);
		}
		@GetMapping("/displayoffre")
		List<Offre> display()
		{
			return Os.retreiveAllOffres();
		}
		@GetMapping("/find/{id}")
		Offre find(@PathVariable("id") int id)
		{
			return Os.retrievOffre(id);
		}
		@GetMapping("/available/{id}")
		String available(@PathVariable("id") int id)
		{
			return Os.available(id);
		}
		
		}

