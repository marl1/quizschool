package access;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import model.Proposition;
import model.Quiz;
import model.Stagiaire;
import model.Theme;

@ManagedBean
@SessionScoped
public class ThemeDao extends Dao<Theme> {
	
	public Theme getThemeById(int id) 
	{
		return em.find(Theme.class, id);
	}

	public List<Theme> getAllThemes() 
	{
        Query requete=em.createQuery("select t from Theme t");
        System.out.println("lol");
        return requete.getResultList();
	}

}
