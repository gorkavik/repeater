package com.snb.repeater.app.domain.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;



import java.util.List;

/**
 * Created by
 * Gorkavik_O
 * 04.02.2018.
 */
@Dao
public interface DBDao {
        // Add question to DB
        @Insert
        void insert(DB db);

        // Delete question from DB
        @Delete
        void delete(DB db);

        // Get questions from DB
        @Query("SELECT * FROM db ")
        List<DB> getAllData();

}
