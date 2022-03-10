package tn.esprit.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.entities.Like;
import tn.esprit.repositories.LikeRepository;

@Service
public class LikeService implements ILikeService {

@Autowired 
	LikeRepository likeReposiory;

	@Override
	public List<Like> retreiveAllLikes() {
		List<Like> listLikes = new ArrayList<Like>();
		try {
			listLikes = (List<Like>) likeReposiory.findAll();
			for(Like f : listLikes)
			{
				 System.out.println("user = "+f);
			}}
			catch(Exception e)
			{
				 System.out.println("error = "+e);
			}
		 
			return listLikes;
	}

	@Override
	public Like addLike(Like f) {
		try
		{
			likeReposiory.save(f);
		}
		catch(Exception e)
		{
			 System.out.println("error = "+e);
		}
		return f;
	}
	

	@Override
	public void deleteLike(long id) {
		
			try{
			//	Long idl = Long.parseLong(id);
				likeReposiory.deleteById(id);
				}
				catch(Exception e)
				{
					 System.out.println("error = "+e);
				}	
		
	}

	@Override
	public Like updateLike(Like f) {
		try
		{
		likeReposiory.save(f);
		}
		catch(Exception e)
		{
			 System.out.println("error = "+e);
		}
		return f;
	}

	@Override
	public Like retrieveLike(long id) {
		Like f = new Like();
		try {
		 f = likeReposiory.findById(id).get();
			}
		catch(Exception e)
		{
			 System.out.println("error = "+e);
		}
		return f ;
	   }

	@Override
	public Like retrieveUser(Like f, int id) {
		 System.out.println("@@@@@@@@@@@");
		 System.out.println(f.getUserid());
	//	 System.out.println(f.getComment().getId());

		return likeReposiory.findUser(f.getUserid(),id);
	}

	@Override
	public String nblike(int id) {
		int like=likeReposiory.nblike(id);
		int dislike=likeReposiory.nbdislike(id);
		float p= ((float)like/((float)like+(float)dislike))*100;
		String slike=String.valueOf(like);
		String sdislike=String.valueOf(dislike);

		return "Likes :"+slike+"  :   "+String.valueOf((int)p)+"%    Dislikes :"+sdislike+"  :  "+String.valueOf(100-(int)p)+"%";
	}
	}

