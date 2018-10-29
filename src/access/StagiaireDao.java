package access;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import model.Proposition;
import model.Quiz;
import model.Stagiaire;

@ManagedBean
@SessionScoped
public class StagiaireDao extends Dao {

	public Stagiaire getStagiaireByLoginPass(String login, String password) 
	{
		Stagiaire s=null;
		Query requete=em.createQuery("select s from Stagiaire s where s.mailStagiaire=:mailStagiaire and s.mdpStagiaire=:mdpStagiaire");
        requete.setParameter("mailStagiaire", login);
        requete.setParameter("mdpStagiaire", password);
         try{
        	 s=(Stagiaire) requete.getSingleResult();
         }catch(NoResultException nre) {
        	 return null;
         }
         return s;
	}

}
