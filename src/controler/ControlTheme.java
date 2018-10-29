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

import access.QuizDao;
import access.ThemeDao;
import model.Module;
import model.Stagiaire;
import model.Theme;

@ManagedBean
@SessionScoped
public class ControlTheme implements Serializable {
	private static final long serialVersionUID = 1L;
	@ManagedProperty(value="#{themeDao}")
	private ThemeDao themeDao;
	private String paramTheme;
	private Theme theme;

	
	
	public void removeModule(Module m) {
		theme.getModules().remove(m);
		themeDao.write(theme);
	}
	
	
	
	public void remove(Theme t) {
		themeDao.delete(t);
	}
	
	
	public void onRowEditModule(RowEditEvent event) {
		Module m=(Module) event.getObject();
		theme.getModules().add(m);
		themeDao.write(theme);
	}
	
	
    public void onRowEdit(RowEditEvent event) {
    	Theme t=(Theme) event.getObject();
    	themeDao.write(t);
    }
     
    public void onRowCancel(RowEditEvent event) {
    	System.out.println("Annulation de l'édition de ligne...");
    }
    
	public ThemeDao getThemeDao() {
		return themeDao;
	}

	public void setThemeDao(ThemeDao themeDao) {
		this.themeDao = themeDao;
	}
	

    public void onAddNewModule() {
    	Module m=new Module(this.theme,"NouveauTheme");
    	theme.getModules().add(m);
    	themeDao.write(theme);
    }

    
    public void onAddNew() {
    	Theme t=new Theme("NouveauTheme");
    	themeDao.write(t);
    }


	public String getParamTheme() {
		return paramTheme;
	}


	public void setParamTheme(String paramTheme) {
		  try  
		  {  
			  setTheme(themeDao.getThemeById(Integer.parseInt(paramTheme)));
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
		this.paramTheme = paramTheme;
	}


	public Theme getTheme() {
		return theme;
	}


	public void setTheme(Theme theme) {
		this.theme = theme;
	}
	
	
}