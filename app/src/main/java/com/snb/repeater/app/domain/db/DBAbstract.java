package com.snb.repeater.app.domain.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.snb.repeater.app.domain.model.DB;

/**
 * Created by
 * Gorkavik_O
 * 04.02.2018.
 */
@Database(entities = {DB.class}, version = 1, exportSchema = false)
public abstract class DBAbstract extends RoomDatabase {

    public abstract DBDao getDBDao(); //return all metods
}
