package controler;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import access.FormateurDao;
import access.QuizDao;
import access.StagiaireDao;
import model.Formateur;
import model.Stagiaire;

@ManagedBean
@SessionScoped
public class ControlLoginFormateur implements Serializable {
	private static final long serialVersionUID = 1L;
	private Formateur formateur;
	private String login;
	private String password;
	@ManagedProperty(value="#{formateurDao}")
	private FormateurDao formateurDao;
	
	
	public void deconnection() {
		this.formateur=null;
	}
	
	
	public void connection() {
		System.out.println("Il faut se connecter avec "+login+" "+password);
		this.formateur=formateurDao.getFormateurByLoginPass(login,password);
		System.out.println(formateur);
	}
	
	

	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


	public Formateur getFormateur() {
		return formateur;
	}


	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}


	public FormateurDao getFormateurDao() {
		return formateurDao;
	}


	public void setFormateurDao(FormateurDao formateurDao) {
		this.formateurDao = formateurDao;
	}

	
	
}