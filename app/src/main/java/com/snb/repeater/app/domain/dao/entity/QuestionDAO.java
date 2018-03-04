package com.snb.repeater.app.domain.dao.entity;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.snb.repeater.app.domain.model.entity.Question;

import java.util.List;

@Dao
public interface QuestionDAO {

    @Insert
    void insert(Question t);

    @Delete
    void delete(Question t);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void update(Question t);

    @Query("SELECT * FROM Question")
    List<Question> getAll();

    @Query("SELECT * FROM Question WHERE id=:id")
    Question findBy(final int id);
}
