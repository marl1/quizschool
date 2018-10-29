package access;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import model.Admin;
import model.Formateur;
import model.Proposition;
import model.Quiz;
import model.Stagiaire;

@ManagedBean
@SessionScoped
public class AdminDao extends Dao {

	public Admin getFormateurByLoginPass(String login, String password) 
	{
		Admin a=null;
		Query requete=em.createQuery("select a from Admin a where a.mailAdmin=:mailAdmin and a.mdpAdmin=:mdpAdmin");
        requete.setParameter("mailAdmin", login);
        requete.setParameter("mdpAdmin", password);
         try{
        	 a=(Admin) requete.getSingleResult();
         }catch(NoResultException nre) {
        	 return null;
         }
         return a;
	}

}
