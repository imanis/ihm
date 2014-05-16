/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.util.List;
import models.Grille;
import models.Lignegrille;
import org.hibernate.Session;

/**
 *
 * @author Anis
 */
public class LigneGrilleDao extends Dao {
    
    public List<Lignegrille> getAllByGrille(Grille g) {
        
        Session s = HibernateUtil.currentSession();
        List<Lignegrille> res = s.createSQLQuery("SELECT * FROM `lignegrille` WHERE `idgrille` ="+g.getIdgrille()).list();
    //    System.out.println("TAILLEEEEE" + res.size());
        return res;
        
    }
}
