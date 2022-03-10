package tn.esprit;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.entities.Collaboration;
import tn.esprit.entities.Comment;
import tn.esprit.entities.Forum;
import tn.esprit.entities.Like;
import tn.esprit.entities.Offre;
import tn.esprit.services.ICollaborationService;
import tn.esprit.services.ICommentService;
import tn.esprit.services.IForumService;
import tn.esprit.services.ILikeService;
import tn.esprit.services.IOffreService;


@RunWith(SpringRunner.class)
@SpringBootTest
class pidevAppTests {

	@Autowired
	IForumService ifs;



	@Test
	public void contextLoads() throws ParseException {
		
		ifs.retreiveAllForums();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d = dateFormat.parse("2020-11-08");
		long id,userid;
		id = 8;
		userid = 5;
		Forum f = new Forum(id,"firstTopic",d,userid, null);
		ifs.addForum(f);
		System.out.println("*********************");
		System.out.println(f.toString());
		
		/*
		icols.retreiveAllCollaborations();
		
	
		Collaboration col = new Collaboration(id,"firstTopic",d);
		icols.addCollaboration(col);
		System.out.println("*********************");
		
		Comment com = new Comment(id,"firstTopic",d,userid);
		icoms.addComment(com);
		System.out.println("*********************");
		
		ils.retreiveAllLikes();
		
		Like l = new Like(id,1,userid);
		ils.addLike(l);
		System.out.println("*********************");
		
		ios.retreiveAllOffres();
		Offre o = new Offre(id,"firstTopic","firstTopic",d,d);
		ios.addOffre(o);
		System.out.println("*********************");
*/
	}

}



	