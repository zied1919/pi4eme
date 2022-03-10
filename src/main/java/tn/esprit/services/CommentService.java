package tn.esprit.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.entities.Comment;
import tn.esprit.repositories.CommentRepository;


@Service
public class CommentService implements ICommentService {


@Autowired 
CommentRepository commentReposiory;

@Override
public List<Comment> retreiveAllComments() {
	List<Comment> listComments = new ArrayList<Comment>();
	try {
		listComments = (List<Comment>) commentReposiory.findAll();
		for(Comment f : listComments)
		{
			 System.out.println("user = "+f);
		}}
		catch(Exception e)
		{
			 System.out.println("error = "+e);
		}
	 
		return listComments;
}

@Override
public Comment addComment(Comment f) {
	try
	{
		
	 commentReposiory.save(f);
	

	}
	catch(Exception e)
	{
		 System.out.println("error = "+e);
	}
	return f;
}

@Override
public void deleteComment(long id) {
	try{
		//	Long idl = Long.parseLong(id);
			commentReposiory.deleteById(id);
			}
			catch(Exception e)
			{
				 System.out.println("error = "+e);
			}	
	
}

@Override
public Comment updateComment(Comment f) {
	try
	{
	commentReposiory.save(f);
	}
	catch(Exception e)
	{
		 System.out.println("error = "+e);
	}
	return f;
}

@Override
public Comment retrieveComment(long id) {
	Comment f = new Comment();
	try{
	 f = commentReposiory.findById(id).get();
		}
	catch(Exception e)
	{
		 System.out.println("error = "+e);
	}
	return f ;
   }

@Override
public int countlikes(long id) {
	Comment f = new Comment();
	f = commentReposiory.findById(id).get();
	f.setNbLike(commentReposiory.countlike(id));
	return f.getNbLike();
}

@Override
public int countdislikes(long id) {
	Comment f = new Comment();
	f = commentReposiory.findById(id).get();
	f.setNbDislike(commentReposiory.countdislike(id));
	return f.getNbDislike();
}

@Override
public void setCount(long id) {
	Comment f = new Comment();
	f = commentReposiory.findById(id).get();
	f.setNbDislike(commentReposiory.countdislike(id));
	f.setNbLike(commentReposiory.countlike(id));

}

@Override
public Comment viral(long id) {
	List<Comment> listComments = new ArrayList<Comment>();
	listComments = (List<Comment>) commentReposiory.retrivebyforum(id);
	for(Comment f : listComments)
	{
		setCount(f.getId());	
	}	
	Comment maxLikes=new Comment();
	maxLikes=listComments.get(0);
	for(Comment f : listComments)
	{
		if(maxLikes.getNbLike()<f.getNbLike()) {
			maxLikes=f;
		}
	}	
	return maxLikes;
}

@Override
public Comment mosthated(long id) {
	List<Comment> listComments = new ArrayList<Comment>();
	listComments = (List<Comment>) commentReposiory.retrivebyforum(id);
	for(Comment f : listComments)
	{
		setCount(f.getId());	
	}	
	Comment maxDislikes=new Comment();
	maxDislikes=listComments.get(0);
	for(Comment f : listComments)
	{
		if(maxDislikes.getNbDislike()<f.getNbDislike()) {
			maxDislikes=f;
		}
	}	
	return maxDislikes;
}



}

