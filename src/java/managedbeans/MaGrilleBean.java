/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managedbeans;

import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import models.Grille;
import models.Lignegrille;
import models.QuestionBs;
import org.primefaces.model.TreeNode;
import services.GrilleService;
import services.LigneGrilleService;

/**
 *
 * @author Anis
 */
@RequestScoped
@ManagedBean
public class MaGrilleBean {
     
private Grille grille;     
GrilleService grille_s= new GrilleService();
LigneGrilleService lignegrille_s= new LigneGrilleService();

 public MaGrilleBean() {  
      
           
    } 

    public Grille getGrille() {
        return grille;
    }

    public void setGrille(Grille grille) {
        this.grille = grille;
    }

  
 

    

}
