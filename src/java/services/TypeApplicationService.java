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
import models.QuestionBs;
import models.Terminal;
import models.TypeApplication;

/**
 *
 * @author Anis
 */
public class TypeApplicationService implements Serializable {

    private Dao dao;

    public TypeApplicationService() {
        this.dao = new Dao();
    }

    public List<TypeApplication> getAll() {
        return dao.getAll(TypeApplication.class);
    }

    public List<TypeApplication> getAllByQuestion(QuestionBs Q) {
        List<TypeApplication> list = dao.getAll(TypeApplication.class);
        List<TypeApplication> result = new ArrayList<>();
        for (TypeApplication t : list) {
            if (t.getQuestionBses().equals(Q)) {
                result.add(t);
            }
        }
        return result;
    }

}
