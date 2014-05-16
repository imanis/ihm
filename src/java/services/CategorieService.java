/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package services;

import dao.Dao;
import java.io.Serializable;
import java.util.List;
import models.Categorie;

/**
 *
 * @author Anis
 */
public class CategorieService implements Serializable{


     private Dao dao;

    public CategorieService() {
        this.dao = new Dao();
    }

  
    public List<Categorie> getAll() {
      return dao.getAll(Categorie.class);
    }
    
}
