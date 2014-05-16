/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package services;

import dao.Dao;
import dao.LigneGrilleDao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import models.Lignegrille;
import models.Grille;
import models.QuestionBs;

/**
 *
 * @author Anis
 */
public class LigneGrilleService implements Serializable {
         private LigneGrilleDao dao;

    public LigneGrilleService() {
        this.dao = new LigneGrilleDao();
    }

    public void save (Lignegrille l ){
        dao.save(l);
    }
  
    public List<Lignegrille> getAll() {
      return dao.getAll(Lignegrille.class);
    }
    public List<Lignegrille> getAllByGrille(Grille g) {
        
      /*  
        List<Lignegrille> result = new ArrayList<>();
        for (Lignegrille l : dao.getAll(Lignegrille.class)) {
            if (g.getLignegrilles().equals(g)) {
                result.add(l);
            }
        }
              */
        return dao.getAllByGrille(g);
     
    }
    
}
