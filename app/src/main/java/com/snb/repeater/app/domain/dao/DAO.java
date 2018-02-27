package com.snb.repeater.app.domain.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.snb.repeater.app.domain.model.DB;

import java.util.List;

@Dao
public interface DAO {
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
