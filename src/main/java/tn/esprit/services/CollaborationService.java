package tn.esprit.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.entities.Collaboration;
import tn.esprit.repositories.CollaborationRepository;

@Service
public class CollaborationService implements ICollaborationService{

	

@Autowired 
CollaborationRepository collaborationReposiory;

	@Override
	public List<Collaboration> retreiveAllCollaborations() {
		List<Collaboration> listCollaborations = new ArrayList<Collaboration>();
		try {
			listCollaborations = (List<Collaboration>) collaborationReposiory.findAll();
			for(Collaboration f : listCollaborations)
			{
				 System.out.println("user = "+f);
				 
				 
				 
			}}
			catch(Exception e)
			{
				 System.out.println("error = "+e);
			}
		 
			return listCollaborations;
	}

	@Override
	public Collaboration addCollaboration(Collaboration f) {
		try
		{
			collaborationReposiory.save(f);
		}
		catch(Exception e)
		{
			 System.out.println("error = "+e);
		}
		return f;
	}

	@Override
	public void deleteCollaboration(long id) {
		try{
			//	Long idl = Long.parseLong(id);
				collaborationReposiory.deleteById(id);
				}
				catch(Exception e)
				{
					 System.out.println("error = "+e);
				}			
	}

	@Override
	public Collaboration updateCollaboration(Collaboration f) {
		try
		{
		collaborationReposiory.save(f);
		}
		catch(Exception e)
		{
			 System.out.println("error = "+e);
		}
		return f;
	}

	@Override
	public Collaboration retrieveCollaboration(long id) {
		Collaboration f = new Collaboration();
		try{

		 f = collaborationReposiory.findById(id).get();
			}
		catch(Exception e)
		{
			 System.out.println("error = "+e);
		}
		return f ;
	   }
	}


