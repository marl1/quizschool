package controler;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Stagiaire;

@ManagedBean
@SessionScoped
public class ControlIndex implements Serializable {
	private static final long serialVersionUID = 1L;
	private int nombreTest=3;
	
	@PostConstruct
	public void onLoad(){
		System.out.println("Création du controleur index...");
	}

	public int getNombreTest() {
		return nombreTest;
	}

	public void setNombreTest(int nombreTest) {
		this.nombreTest = nombreTest;
	}
}