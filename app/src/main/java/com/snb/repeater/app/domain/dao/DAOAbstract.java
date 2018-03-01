package com.snb.repeater.app.domain.dao;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.snb.repeater.app.domain.model.Answer;
import com.snb.repeater.app.domain.model.Question;

@Database(entities = {Answer.class, Question.class}, version = 1)
abstract class DAOAbstract extends RoomDatabase {
    public abstract DAO getDBDao();
}
