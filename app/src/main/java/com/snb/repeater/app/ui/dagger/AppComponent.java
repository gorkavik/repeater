package com.snb.repeater.app.ui.dagger;

import com.snb.repeater.app.domain.conccurent.executor.AppExecutor;
import com.snb.repeater.app.domain.conccurent.executor.AppExecutorModule;
import com.snb.repeater.app.domain.dao.DAOModule;
import com.snb.repeater.app.domain.dao.entity.AnswerDAO;
import com.snb.repeater.app.domain.dao.entity.QuestionDAO;
import com.snb.repeater.app.domain.dao.relation.Question2AnswerDAO;

import dagger.Component;

@Component(modules = {AppExecutorModule.class, DAOModule.class})
public interface AppComponent {

    AppExecutor getAppExecutor();

    AnswerDAO getAnswerDao();

    QuestionDAO getQuestionDao();

    Question2AnswerDAO getQuestion2AnswerDao();
}
