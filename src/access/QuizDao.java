package access;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.Quiz;

@ManagedBean
@SessionScoped
public class QuizDao extends Dao {

	public Quiz getQuizById(int id) // cherche avec la clef
	{
		return em.find(Quiz.class, id);
	}

}
