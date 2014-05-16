/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.util.List;

import models.Grille;
import models.Lignegrille;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;

/**
 *
 * @author Anis
 */
public class GrilleDao extends Dao {
    
    public Grille getById(long id) {
        
        Session s = HibernateUtil.currentSession();
        //Grille res =(Grille) s.createSQLQuery("SELECT * FROM `grille` WHERE `idgrille` ="+id).uniqueResult();
        Criteria criteria;
        criteria  = s.createCriteria(Grille.class);
        criteria.add(Expression.eq("idgrille",Integer.parseInt(id+"")));
        return (Grille) criteria.uniqueResult();
        
    }
}
