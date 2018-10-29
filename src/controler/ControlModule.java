package controler;
import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

import access.ModuleDao;
import access.QuizDao;
import access.ThemeDao;
import model.Formateur;
import model.Module;
import model.Quiz;
import model.Stagiaire;
import model.Theme;

@ManagedBean
@SessionScoped
public class ControlModule implements Serializable {
	private static final long serialVersionUID = 1L;
	@ManagedProperty(value="#{moduleDao}")
	private ModuleDao moduleDao;
	private String paramModule;
	private Module module;
	
	
	public void removeQuiz(Quiz q) {
		module.getQuizs().remove(q);
		moduleDao.write(module);
	}
	
    public void onAddNewQuiz() {
    	Formateur f=new Formateur(1);
    	Quiz q=new Quiz(f, this.module,"NouveauQuiz",false);
    	this.module.getQuizs().add(q);
    	moduleDao.write(module);
    }
    
    public void onRowEdit(RowEditEvent event) {
    	Quiz q=(Quiz) event.getObject();
    	this.module.getQuizs().add(q);
    	moduleDao.write(module);
    }
     
    public void onRowCancel(RowEditEvent event) {
    	System.out.println("Annulation de l'édition de ligne...");
    }


	public ModuleDao getModuleDao() {
		return moduleDao;
	}


	public void setModuleDao(ModuleDao moduleDao) {
		this.moduleDao = moduleDao;
	}
    
	public void setParamModule(String paramModule) {
		  try  
		  {  
			  setModule(moduleDao.getThemeById(Integer.parseInt(paramModule)));
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
		  System.out.println(paramModule);
		this.paramModule = paramModule;
	}


	public String getParamModule() {
		return paramModule;
	}



	public Module getModule() {
		return module;
	}


	public void setModule(Module module) {
		this.module = module;
	}
	
	
}