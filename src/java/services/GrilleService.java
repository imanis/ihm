/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.Dao;
import dao.GrilleDao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import models.Categorie;
import models.Grille;
import models.Lignegrille;

/**
 *
 * @author Anis
 */
public class GrilleService implements Serializable {

    private GrilleDao dao;

    public GrilleService() {
        this.dao = new GrilleDao();
    }

    public void save(Grille g) {
        //    System.out.println(g);
        dao.save(g);
    }

    public List<Grille> getAll() {
        List<Grille> l;
        l = dao.getAll(Grille.class);
        System.out.println("--------TAILLE : " + l.size());
        return l;
    }

    public Grille get(Grille g) {
        Grille gr = Dao.initializeAndUnproxy(g);
        for (Lignegrille l : gr.getLignegrilles()) {
            Dao.initializeAndUnproxy(l);
            Dao.initializeAndUnproxy(l.getQuestionBs());
        }

        //   System.out.println( "TEST " + new ArrayList<Lignegrille>(gr.getLignegrilles()).get(0).getQuestionBs().getQuestion());
        return gr;
    }

    public Grille getById(long id) {

        Grille gr = dao.getById(id);
        for (Lignegrille l : gr.getLignegrilles()) {
            Dao.initializeAndUnproxy(l);
            Dao.initializeAndUnproxy(l.getQuestionBs());
        }

        // System.out.println( "TEST " + new ArrayList<Lignegrille>(gr.getLignegrilles()).get(0).getQuestionBs().getQuestion());
        return gr;
    }

    public void delete(Grille grille) {
        dao.delete(grille);
    }

}
