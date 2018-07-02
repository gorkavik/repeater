package com.snb.repeater.app.domain.dao.abstr;

import android.arch.persistence.room.Room;

import com.snb.repeater.app.domain.context.Holder;
import com.snb.repeater.app.domain.dao.entity.AnswerDAO;
import com.snb.repeater.app.domain.dao.entity.QuestionDAO;
import com.snb.repeater.app.domain.dao.relation.Question2AnswerDAO;

public class DAOFactory {

    private final static DAOFactory INSTANCE = new DAOFactory();

    public static DAOFactory getINSTANCE() {
        return INSTANCE;
    }

    private final DAOAbstract DB = Room
            .databaseBuilder(Holder.getContext(), DAOAbstract.class, "data-database")
            .build();

    public AnswerDAO getAnswerDao() {
        return DB.getAnswerDao();
    }

    public QuestionDAO getQuestionDao() {
        return DB.getQuestionDao();
    }

    public Question2AnswerDAO getQuestion2AnswerDao() {
        return DB.getQuestion2AnswerDao();
    }
}
