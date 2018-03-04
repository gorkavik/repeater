package com.snb.repeater.app.domain.dao.abstr;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.snb.repeater.app.domain.dao.entity.AnswerDAO;
import com.snb.repeater.app.domain.dao.entity.QuestionDAO;
import com.snb.repeater.app.domain.dao.relation.Question2AnswerDAO;
import com.snb.repeater.app.domain.model.entity.Answer;
import com.snb.repeater.app.domain.model.entity.Question;
import com.snb.repeater.app.domain.model.relations.Question2Answer;

@Database(entities = {Answer.class, Question.class, Question2Answer.class}, version = 1)
abstract class DAOAbstract extends RoomDatabase {

    /*
    * Entities
    * */
    abstract AnswerDAO getAnswerDao();

    abstract QuestionDAO getQuestionDao();

    /*
    * Relations
    * */
    abstract Question2AnswerDAO getQuestion2AnswerDao();
}
