package access;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import model.Formateur;
import model.Proposition;
import model.Quiz;
import model.Stagiaire;

@ManagedBean
@SessionScoped
public class FormateurDao extends Dao {

	public Formateur getFormateurByLoginPass(String login, String password) 
	{
		Formateur f=null;
		Query requete=em.createQuery("select f from Formateur f where f.mailFormateur=:mailFormateur and f.mdpFormateur=:mdpFormateur");
        requete.setParameter("mailFormateur", login);
        requete.setParameter("mdpFormateur", password);
         try{
        	 f=(Formateur) requete.getSingleResult();
         }catch(NoResultException nre) {
        	 return null;
         }
         return f;
	}

}
