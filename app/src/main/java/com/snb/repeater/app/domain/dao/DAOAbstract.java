package com.snb.repeater.app.domain.dao;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.snb.repeater.app.domain.model.DB;

@Database(entities = {DB.class}, version = 1, exportSchema = false)
abstract class DAOAbstract extends RoomDatabase {
    public abstract DAO getDBDao();
}
