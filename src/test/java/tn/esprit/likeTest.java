package tn.esprit;

import java.text.ParseException;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.entities.Like;
import tn.esprit.services.ILikeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class likeTest {
	@Autowired
	ILikeService ifs;
	
	
	@Test
	public void contextLoads() throws ParseException {
		
		System.out.println("*********************");
		Like l = new Like();
		l = ifs.retrieveLike(1);
		//System.out.println(ifs.retrieveUser(l).getEtat());
		//fSystem.out.println(ifs.retrieveUser(l).getId());



	}}
