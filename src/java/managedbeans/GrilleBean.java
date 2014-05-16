/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import models.Grille;
import models.Lignegrille;
import services.GrilleService;
import services.LigneGrilleService;

/**
 *
 * @author Anis
 */
@ManagedBean
@ViewScoped
public class GrilleBean implements Serializable {

    public List<Grille> grilles;
    GrilleService grille_s = new GrilleService();
    LigneGrilleService lignegrille_s = new LigneGrilleService();

    public GrilleBean() {

        grilles = grille_s.getAll();
        System.out.println("Taille --c-c-" + grilles.size());

    }

    public List<Grille> getGrilles() {
        return grilles;
    }

    public void setGrilles(List<Grille> grille) {
        this.grilles = grille;
    }





    public String affichenote(Grille g) {
        if (g.getNote() != -1) {
            return g.getNote().toString();
        } else {
            return "pas de note";
        }

    }

    public String showDetails(Grille g) {
        System.out.println("# Affichage  grille #");
        // System.out.println(selectedgrille.getNomgrille());
      //  this.selectedgrille = grille_s.get(g);

        return "detaileGrille?id="+ g.getIdgrille()+"&faces-redirect=true";
    }


}
