package access;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import model.Module;
import model.Proposition;
import model.Quiz;
import model.Stagiaire;
import model.Theme;

@ManagedBean
@SessionScoped
public class ModuleDao extends Dao {
	
	public Module getThemeById(int id) 
	{
		return em.find(Module.class, id);
	}

}
