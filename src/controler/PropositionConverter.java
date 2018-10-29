package controler;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import access.PropositionDao;
import access.QuizDao;
import model.Proposition;

@ManagedBean
@SessionScoped
public class PropositionConverter implements Converter {
	@ManagedProperty(value="#{propositionDao}")
	private PropositionDao propositionDao;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
       //retourne un objet en fonction du champ html value (du num d'étudiant)
    	System.out.println("On retourne "+propositionDao.getPropositionById(Integer.parseInt(value)).getClass().getSimpleName());
        return propositionDao.getPropositionById(Integer.parseInt(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        //remplit le champ "value=" du select html avec le numéro d'étudiant
        if(value==null){
            return "";
        }
        return String.valueOf(((Proposition)value).getIdProposition());
    }

	public PropositionDao getPropositionDao() {
		return propositionDao;
	}

	public void setPropositionDao(PropositionDao propositionDao) {
		this.propositionDao = propositionDao;
	}
    
    
}
