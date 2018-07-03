package com.snb.repeater.app.domain.dao;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.snb.repeater.app.domain.context.ContextModule;
import com.snb.repeater.app.domain.dao.entity.AnswerDAO;
import com.snb.repeater.app.domain.dao.entity.QuestionDAO;
import com.snb.repeater.app.domain.dao.relation.Question2AnswerDAO;

import dagger.Module;
import dagger.Provides;

@Module(includes = ContextModule.class)
public class DAOModule {

    private final DAOAbstract dao;

    public DAOModule(final Context context) {
        this.dao = Room
                .databaseBuilder(context, DAOAbstract.class, "data-database")
                .build();
    }

    @Provides
    public DAOAbstract getDao(final Context context) {
        return dao;
    }

    @Provides
    public AnswerDAO getAnswerDao() {
        return dao.getAnswerDao();
    }

    @Provides
    public QuestionDAO getQuestionDao() {
        return dao.getQuestionDao();
    }

    @Provides
    public Question2AnswerDAO getQuestion2AnswerDao() {
        return dao.getQuestion2AnswerDao();
    }
}
