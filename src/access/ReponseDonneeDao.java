package access;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.Donner;
import model.Proposition;
import model.Quiz;

@ManagedBean
@SessionScoped
public class ReponseDonneeDao extends Dao {

	public Donner getPropositionById(int id) 
	{
		return em.find(Donner.class, id);
	}

}
