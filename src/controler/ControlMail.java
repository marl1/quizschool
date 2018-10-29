package controler;
import java.io.IOException;
import java.io.Serializable;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Stagiaire;

@ManagedBean
@SessionScoped
public class ControlMail implements Serializable {
	private static final long serialVersionUID = 1L;
	private String mail;
	
	@PostConstruct
	public void onLoad(){
		System.out.println("Création du controleur mail...");

	}

	
	public void envoyerMail() {
		System.out.println("Envoie d'un mail à "+mail+"...");

		/*
		  String to = mail;
	      String from = "web@gmail.com";
	      String host = "localhost";
	      Properties properties = System.getProperties();
	      properties.setProperty("mail.smtp.host", host);
	      Session session = Session.getDefaultInstance(properties);
	      try {
	         MimeMessage message = new MimeMessage(session);
	         message.setFrom(new InternetAddress(from));
	         message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
	         message.setSubject("Inscription à la Quiz School Academy");
	         message.setText("Bienvenue, voici le lien secret pour s'inscrire blabla.");
	         Transport.send(message);
	         System.out.println("Sent message successfully....");
	      } catch (MessagingException mex) {
	         mex.printStackTrace();
	      }
	      */
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("..");
		} catch (IOException e) {
		}
	}
	
	
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	

}