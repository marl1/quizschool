package access;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.Proposition;
import model.Quiz;

@ManagedBean
@SessionScoped
public class PropositionDao extends Dao {

	public Proposition getPropositionById(int id) 
	{
		return em.find(Proposition.class, id);
	}

}
