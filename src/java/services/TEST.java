/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package services;

import java.util.List;
import models.Grille;

/**
 *
 * @author Anis
 */
public class TEST {
    
    
    public static void main(String[] args){
        
        GrilleService gs = new GrilleService();
        LigneGrilleService ls = new LigneGrilleService();
        
        List<Grille> listgrille = gs.getAll();
        
        System.out.println(listgrille.size());
        
    }
}
