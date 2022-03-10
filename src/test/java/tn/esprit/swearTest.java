package tn.esprit;

import java.text.ParseException;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.services.IForumService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class swearTest {
	@Autowired
	IForumService ifs;
	
	
	@Test
	public void contextLoads() throws ParseException {
		
		System.out.println("*********************");
		System.out.println(ifs.listswears().get(1));
		//System.out.println(ifs.swearAction("fuck"));


}}
