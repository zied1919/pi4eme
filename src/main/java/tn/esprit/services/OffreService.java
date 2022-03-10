package tn.esprit.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import tn.esprit.entities.Offre;
import tn.esprit.repositories.OffreRepository;


@Service
public class OffreService implements IOffreService{


@Autowired 
OffreRepository offreReposiory;


@Override
public List<Offre> retreiveAllOffres() {
	List<Offre> listOffres = new ArrayList<Offre>();
	try {
		listOffres = (List<Offre>) offreReposiory.findAll();
		for(Offre f : listOffres)
		{
			 System.out.println("user = "+f);
		}}
		catch(Exception e)
		{
			 System.out.println("error = "+e);
		}
	 
		return listOffres;
}

@Override
public Offre addOffre(Offre f) {
	try
	{
		offreReposiory.save(f);
		sendmail(f);
		//sendSMS(f);
		
	}
	catch(Exception e)
	{
		 System.out.println("error = "+e);
	}
	return f;
}

@Override
public void deleteOffre(long id) {
	try{
	//	Long idl = Long.parseLong(id);
		offreReposiory.deleteById(id);
		}
		catch(Exception e)
		{
			 System.out.println("error = "+e);
		}	
}

@Override
public Offre updateOffre(Offre f) {
	try
	{
		offreReposiory.save(f);
	}
	catch(Exception e)
	{
		 System.out.println("error = "+e);
	}
	return f;
}

@Override
public Offre retrievOffre(long id) {
	Offre f = new Offre();
	try{

	 f = offreReposiory.findById(id).get();

		}
	catch(Exception e)
	{
		 System.out.println("error = "+e);
	}
	return f ;
   }

@Override
public int notstarted(int id) {
	return offreReposiory.notstarted(id);
}

@Override
public int finished(int id) {
	return offreReposiory.finished(id);
}

@Override
public int inprogress(int id) {
	return offreReposiory.inprogress(id);
}

@Override
public String available(int id) {
	int ns=offreReposiory.notstarted(id);
	int f=offreReposiory.finished(id);
	int ip=offreReposiory.inprogress(id);
	float pns= ((float)ns/((float)f+(float)ip+(float)ns))*100;
	float pf= ((float)f/((float)f+(float)ip+(float)ns))*100;
	float pip= ((float)ip/((float)f+(float)ip+(float)ns))*100;
	String sns=String.valueOf(ns);
	String sf=String.valueOf(f);
	String sip=String.valueOf(ip);
	String t=String.valueOf(offreReposiory.total(id));

	
	return "Offres Not Started : "+sns+"  :   "+String.valueOf((int)pns)+"%    Offres In Progress : "+sip+"  :  "+String.valueOf((int)pip)+"%"+"%    Offres Finished : "+sf+"  :  "+String.valueOf((int)pf)+"% "+ "\n" +" Total Offers : "+t;
}


private JavaMailSender javaMailSender;

public void EmailService(JavaMailSender javaMailSender) {
    this.javaMailSender = javaMailSender;
}
public void sendmail(Offre o)  
{
	JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
	mailSender.setHost("smtp.gmail.com");
	mailSender.setPort(587);
	mailSender.setUsername("spring.pidev@gmail.com");
	mailSender.setPassword("seifderbali10");
	 
	Properties properties = new Properties();
	properties.setProperty("mail.smtp.auth", "true");
	properties.setProperty("mail.smtp.starttls.enable", "true");
	 
	mailSender.setJavaMailProperties(properties);
	String from = mailSender.getUsername();
	String to = o.getCollaboration().getMail();
	 
	SimpleMailMessage message = new SimpleMailMessage();
	 
	message.setFrom(from);    	
	message.setTo(to);
	message.setSubject("New Offre");
	message.setText("New Offre has been added"+"\r"+"Nom : "+o.getNom()+"\r"+"Description : "+o.getDescription()+"\r"+"Start Date :"+o.getStartDate()+"\r"+"End Date :"+o.getEndDate());
	
	mailSender.send(message);
	
}

public static final String ACCOUNT_SID = "AC26234acceccad62a4b477a9041190f33";
public static final String AUTH_TOKEN = "d50f1f0e11cabef5591203ef76770a0c";

public static void sendSMS(Offre o) {
  Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

  Message message = Message.creator(new PhoneNumber(o.getPhone()),
      new PhoneNumber("+18166703736"), 
      "New Offre has been added "+"\r"+"Nom : "+o.getNom()+"\r"+"Description : "+o.getDescription()+"\r"+"Start Date :"+o.getStartDate()+"\r"+"End Date :"+o.getEndDate()).create();

  System.out.println(message.getSid());
}

}
