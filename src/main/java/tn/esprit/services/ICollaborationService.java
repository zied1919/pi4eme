package tn.esprit.services;

import java.util.List;

import tn.esprit.entities.Collaboration;



public interface ICollaborationService {
		List<Collaboration> retreiveAllCollaborations();
		Collaboration addCollaboration(Collaboration f);
		void deleteCollaboration(long id);
		Collaboration updateCollaboration(Collaboration f);
		Collaboration retrieveCollaboration(long id);
}
