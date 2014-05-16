/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import dao.Dao;
import dao.HibernateUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import models.Grille;
import models.Lignegrille;
import org.apache.myfaces.context.servlet.RequestParameterMap;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import services.GrilleService;
import services.LigneGrilleService;

/**
 *
 * @author Anis
 */
@ManagedBean
@RequestScoped
public class EditGrilleBean implements Serializable {

    Grille grille;
    Lignegrille selectligne;
    List<Lignegrille> lignes;
    GrilleService grille_s = new GrilleService();
    LigneGrilleService lignegrille_s = new LigneGrilleService();

    public EditGrilleBean() {
        
   //     System.out.println("Connsst");

        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        long id = Long.parseLong(params.get("id"));

        grille = grille_s.getById(id);

        lignes = new ArrayList<>(grille.getLignegrilles());

    }

    public Grille getGrille() {
        return grille;
    }

    public void setGrille(Grille grille) {
        this.grille = grille;
    }

    public Lignegrille getSelectligne() {
        System.out.println("GET");
        return selectligne;
    }

    public void setSelectligne(Lignegrille selectligne) {
        System.out.println("SET");
        this.selectligne = selectligne;
    }

    public List<Lignegrille> getLignes() {
        return lignes;
    }

    public void setLignes(List<Lignegrille> lignes) {
        this.lignes = lignes;
    }

    
       public boolean justification(String j) {
           System.out.println(j);
        return !j.isEmpty();
        //return false;
    }
       
       public String save(){
           grille_s.save(grille);
           return "listeGrille.xhtml?faces-redirect=true";
           
       }
}
