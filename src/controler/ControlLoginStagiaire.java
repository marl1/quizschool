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

import access.QuizDao;
import access.StagiaireDao;
import model.Stagiaire;

@ManagedBean
@SessionScoped
public class ControlLoginStagiaire implements Serializable {
	private static final long serialVersionUID = 1L;
	private Stagiaire stagiaire;
	private String login;
	private String password;
	@ManagedProperty(value="#{stagiaireDao}")
	private StagiaireDao stagiaireDao;
	
	
	public void deconnection() {
		this.stagiaire=null;
	}
	
	
	public void connection() {
		System.out.println("Il faut se connecter avec "+login+" "+password);
		this.stagiaire=stagiaireDao.getStagiaireByLoginPass(login,password);
		System.out.println(stagiaire);
	}
	
	
	public Stagiaire getStagiaire() {
		return stagiaire;
	}
	public void setStagiaire(Stagiaire stagiaire) {
		this.stagiaire = stagiaire;
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


	public StagiaireDao getStagiaireDao() {
		return stagiaireDao;
	}


	public void setStagiaireDao(StagiaireDao stagiaireDao) {
		this.stagiaireDao = stagiaireDao;
	}
	
	
	
}