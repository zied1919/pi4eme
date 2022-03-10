package tn.esprit.services;

import java.util.List;

import tn.esprit.entities.Forum;


public interface IForumService {
	List<Forum> retreiveAllForums();
	Forum addForum(Forum f);
	void deleteForum(long id);
	Forum updateForum(Forum f);
	Forum retrieveForum(long id);
	List<Forum> searchForums(String keyword);
	int swearAction(String  ch) ;
	List<String> listswears() ;
	int stats(int id) ;
	List<Forum> display(int id) ;
	Forum viral();


}
