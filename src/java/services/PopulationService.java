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
import models.PopulationCible;
import models.QuestionBs;
import models.TypeApplication;

/**
 *
 * @author Anis
 */
public class PopulationService implements Serializable {

    private Dao dao;

    public PopulationService() {
        this.dao = new Dao();
    }

    public List<PopulationCible> getAll() {
        return dao.getAll(PopulationCible.class);
    }

    public List<PopulationCible> getAllByQuestion(QuestionBs Q) {
        List<PopulationCible> list = dao.getAll(PopulationCible.class);
        List<PopulationCible> result = new ArrayList<>();
        for (PopulationCible t : list) {
            if (t.getQuestionBses().equals(Q)) {
                result.add(t);
            }
        }
        return result;
    }

}
