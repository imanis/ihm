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
import models.QuestionBs;
import models.Terminal;

/**
 *
 * @author Anis
 */
public class TerminalService implements Serializable {

    private Dao dao;

    public TerminalService() {
        this.dao = new Dao();
    }

    public List<Terminal> getAll() {
        return dao.getAll(Terminal.class);
    }



    public List<Terminal> getAllByQuestion(QuestionBs Q) {
        List<Terminal> list = dao.getAll(Terminal.class);
        List<Terminal> result = new ArrayList<>();
        for (Terminal t : list) {
            if (t.getQuestionBses().equals(Q)) {
                result.add(t);
            }
        }
        return result;
    }
    
}
