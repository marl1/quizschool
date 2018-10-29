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

import access.AdminDao;
import access.FormateurDao;
import access.QuizDao;
import access.StagiaireDao;
import model.Admin;
import model.Formateur;
import model.Stagiaire;

@ManagedBean
@SessionScoped
public class ControlLoginAdmin implements Serializable {
	private static final long serialVersionUID = 1L;
	private Admin admin;
	private String login;
	private String password;
	@ManagedProperty(value="#{adminDao}")
	private AdminDao adminDao;
	
	
	public void deconnection() {
		this.admin=null;
	}
	
	
	public void connection() {
		System.out.println("Il faut se connecter avec "+login+" "+password);
		this.admin=adminDao.getFormateurByLoginPass(login,password);
		System.out.println(admin);
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


	public Admin getAdmin() {
		return admin;
	}


	public void setAdmin(Admin admin) {
		this.admin = admin;
	}


	public AdminDao getAdminDao() {
		return adminDao;
	}


	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}



	
	
}