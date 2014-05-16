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
import models.CritereBs;
import models.*;
import models.QuestionBs;

/**
 *
 * @author Anis
 */
public class QuestionService implements Serializable {

    private Dao dao;

    public QuestionService() {
        this.dao = new Dao();
    }

    public List<QuestionBs> getAll() {
        return dao.getAll(QuestionBs.class);
    }

    public List<QuestionBs> getAllByCritere(CritereBs crit) {
        List<QuestionBs> list = dao.getAll(QuestionBs.class);
        List<QuestionBs> result = new ArrayList<>();
        for (QuestionBs q : list) {
            if (q.getCritereBs().equals(crit)) {
                result.add(q);
            }
        }
        return result;
    }

    public List<QuestionBs> getAllFiltre(TypeApplication type, Terminal term, PopulationCible population) {

        List<QuestionBs> result = new ArrayList<>();
        for (QuestionBs q : dao.getAll(QuestionBs.class)) {
            List<TypeApplication> l1 = new TypeApplicationService().getAllByQuestion(q);
            List<Terminal> l2 = new TerminalService().getAllByQuestion(q);
            List<PopulationCible> l3 = new PopulationService().getAllByQuestion(q);

            if ( (l1.contains(type))
                    && (l2.contains(term))
                    && (l3.contains(population))) {
                result.add(q);
            }
        }
        return result;
    }

}
