/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import models.Categorie;
import services.CategorieService;

/**
 *
 * @author Anis
 */
@ManagedBean
@RequestScoped
public class CatBean {

    private List<Categorie> cats;
    CategorieService categorie_s = new CategorieService();

    public CatBean() {
        cats = categorie_s.getAll();
    }

    public List<Categorie> getCats() {
        return cats;
    }
}
