/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package services;

import dao.Dao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import models.Categorie;
import models.CritereBs;

/**
 *
 * @author Anis
 */
public class CritereService implements Serializable{


     private Dao dao;

    public CritereService() {
        this.dao = new Dao();
    }

  
    public List<CritereBs> getAll() {
      return dao.getAll(CritereBs.class);
    }
    
    public List<CritereBs> getAllByCategorie(Categorie cat) {
      List<CritereBs> list =  dao.getAll(CritereBs.class);
      List<CritereBs> result = new ArrayList<>();
      for(CritereBs c : list){
          if(c.getCategorie().equals(cat))
              result.add(c);
      }
      return result;
      
    }
    
}
