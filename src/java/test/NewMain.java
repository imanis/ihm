/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import java.util.Date;
import models.Grille;
import services.*;

/**
 *
 * @author Anis
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        GrilleService gs = new GrilleService();
        System.out.println("Taile "+gs.getAll().size());
       // System.out.println(new Grille().getDate());
    }
    
    
}
