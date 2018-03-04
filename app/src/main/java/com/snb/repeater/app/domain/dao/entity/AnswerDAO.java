package com.snb.repeater.app.domain.dao.entity;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.snb.repeater.app.domain.model.entity.Answer;

import java.util.List;

@Dao
public interface AnswerDAO {

    @Insert
    void insert(Answer t);

    @Delete
    void delete(Answer t);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void update(Answer t);

    @Query("SELECT * FROM Answer")
    List<Answer> getAll();

    @Query("SELECT * FROM Answer WHERE id=:id")
    Answer findBy(final int id);
}
