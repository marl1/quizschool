package controler;


import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.primefaces.PrimeFaces;
import org.primefaces.context.RequestContext;

import com.ocpsoft.pretty.faces.annotation.URLAction;
import com.ocpsoft.pretty.faces.annotation.URLMapping;

import access.QuizDao;
import access.ReponseDonneeDao;
import model.Proposition;
import model.Question;
import model.Quiz;
import model.Stagiaire;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

@ManagedBean
@SessionScoped
public class ControlQuiz implements Serializable {
	private static final long serialVersionUID = 1L;
	private String paramQuiz;	
	private Quiz quiz;	
	private ArrayList<Question> currentQuestionsLeft;
	private int currentQuestionIndex;
	private int secondsLeft;
	private boolean quizStarted=false;
	private Proposition chosenProposition;
	private int scoreQuiz1; //utilisé seulement pour le premier quiz car le stagiaire n'étant pas inscrit on utilise pas la base
	
	
	@ManagedProperty(value="#{quizDao}")
	private QuizDao quizDao;
	
	@ManagedProperty(value="#{reponseDonneeDao}")
	private ReponseDonneeDao reponseDonneeDao;
	
    public void buttonAction(ActionEvent actionEvent) {
        addMessage("Welcome to Primefaces!!");
    }
     
    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
	
	@PostConstruct
	public void onLoad(){
		System.out.println("Création du controleur quiz");

	}
	
	public void demarrerQuiz() {
		System.out.println("Demande de démarrage du quiz !");
		this.setQuizStarted(true);
	}


	public ArrayList<Question> getCurrentQuestionsLeft() {
		return currentQuestionsLeft;
	}

	public void setCurrentQuestionsLeft(ArrayList<Question> currentQuestionsLeft) {
		this.currentQuestionsLeft = currentQuestionsLeft;
	}

	public boolean isQuizStarted() {
		return quizStarted;
	}

	public void setQuizStarted(boolean quizStarted) {
		this.quizStarted = quizStarted;
	}

	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}


	public void setQuizNumber(int quizNumber) {
		System.out.println("Le quiz est "+quiz);
		if(quiz==null ) { //le quiz est null, on charge un nouveau quiz
			System.out.println("Chargement d'un nouveau quiz..");
			System.out.println(this.quizDao.getQuizById(quizNumber).getNomTest());
			this.quiz=this.quizDao.getQuizById(quizNumber);
			currentQuestionsLeft = new ArrayList<Question>(this.quiz.getQuestions());
			 
			this.setCurrentQuestionsLeft(currentQuestionsLeft);
		}else if (this.quiz.getIdTest()!=quizNumber) { //l'user a envoyé un nouveau n° de quiz
				System.out.println("le quiz en cours est "+this.quiz.getIdTest()+" et on veut"+quizNumber);
	            PrimeFaces.current().executeScript("PF('confirmerChangerQuiz').show()");
		}else {
			System.out.println("Il a été demandé le même quiz que le quiz actuellement en cours");
		}
		
	}

	
	public String getParamQuiz() {
		return paramQuiz;
	}

	public void launchNextQuestion() {
		System.out.println("On mémorise la réponse");
		
		if(this.quiz.getIdTest()==1) {
			System.out.println("Sauf là, car c'est le quiz 1 et le stagiaire est pas encore inscrit. On vérifie juste que la réponse est bonne pour augmenter le score qui est actuellement de "+scoreQuiz1);
			if(this.chosenProposition.getPropositionJuste()==true) {
				this.scoreQuiz1++;
				System.out.println("La réponse était juste, le score passe à "+scoreQuiz1);
			}
		}
		
		System.out.println("On passe à la question suivante, si "+(this.currentQuestionIndex+1)+" est plus petit que "+this.getCurrentQuestionsLeft().size());
		if(this.currentQuestionIndex+1<this.getCurrentQuestionsLeft().size()) {
			this.currentQuestionIndex++;
		}else {
			System.out.println("Fin du quiz !");
			if(this.quiz.getIdTest()==1) {
				if((this.scoreQuiz1-1)==this.getCurrentQuestionsLeft().size())
				System.out.println("C'était le quiz 1 et il a été réussi, on demande le mail à l'étudiant.");
				try {
					FacesContext.getCurrentInstance().getExternalContext().redirect("../protected/mail.xhtml");
				} catch (IOException e) {
				}
			}
		}
	}
	
	public void setParamQuiz(String paramQuiz) {
		System.out.println("Quelqu'un veut changer le paramQuiz");
		  try  
		  {  
			  //il faudrait vérifier qu'on ait accès au quizz etc au lieu d'assigner direct
			  setQuizNumber(Integer.parseInt(paramQuiz));
		  }  
		  catch(NumberFormatException nfe)  
		  {  
			  try {
				//FacesContext.getCurrentInstance().getExternalContext().getSession(true); //la session n'est pas créé toute seule, faut la forcer https://stackoverflow.com/questions/22898944/jsf-2-2-java-lang-illegalstateexception-cannot-create-a-session-after-the-respo
				FacesContext.getCurrentInstance().getExternalContext().redirect("../erreur.xhtml");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  }
		  
		this.paramQuiz = paramQuiz;
	}

	public QuizDao getQuizDao() {
		return quizDao;
	}

	public void setQuizDao(QuizDao quizDao) {
		this.quizDao = quizDao;
	}

	public int getCurrentQuestionIndex() {
		return currentQuestionIndex;
	}

	public void setCurrentQuestionIndex(int currentQuestionIndex) {
		this.currentQuestionIndex = currentQuestionIndex;
	}

	public int getSecondsLeft() {
		return secondsLeft;
	}

	public void setSecondsLeft(int secondsLeft) {
		this.secondsLeft = secondsLeft;
	}

	public Proposition getChosenProposition() {
		return chosenProposition;
	}

	public void setChosenProposition(Proposition chosenProposition) {
		System.out.println("Pop set : "+chosenProposition);
		this.chosenProposition = chosenProposition;
	}

	public int getScoreQuiz1() {
		return scoreQuiz1;
	}

	public void setScoreQuiz1(int scoreQuiz1) {
		this.scoreQuiz1 = scoreQuiz1;
	}

	public ReponseDonneeDao getReponseDonneeDao() {
		return reponseDonneeDao;
	}

	public void setReponseDonneeDao(ReponseDonneeDao reponseDonneeDao) {
		this.reponseDonneeDao = reponseDonneeDao;
	}
	
	

	
}