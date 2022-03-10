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

import tn.esprit.entities.Collaboration;
import tn.esprit.services.CollaborationService;


@RestController
@RequestMapping("/Collaboration")
public class CollaborationController {
	
	@Autowired
	CollaborationService Cos;
	@PostMapping("/addcollaboration") 
	void add(@RequestBody Collaboration f)
	{
		Cos.addCollaboration(f);
	}
	@PutMapping("/updatecollaboration")
	void update(@RequestBody Collaboration f)
	{
		Cos.updateCollaboration(f);
	}
	@DeleteMapping("/deletecollaboration/{id}")
	void delete(@PathVariable("id") int id)
	{
		Cos.deleteCollaboration(id);
	}
	@GetMapping("/displaycollaborations")
	List<Collaboration> display()
	{
		return Cos.retreiveAllCollaborations();
	}
	@GetMapping("/find/{id}")
	Collaboration find(@PathVariable("id") int id)
	{
		return Cos.retrieveCollaboration(id);
	}
	}


