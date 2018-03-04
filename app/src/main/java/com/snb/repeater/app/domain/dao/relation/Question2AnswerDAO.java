package com.snb.repeater.app.domain.dao.relation;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.snb.repeater.app.domain.model.entity.Answer;
import com.snb.repeater.app.domain.model.entity.Question;
import com.snb.repeater.app.domain.model.relations.Question2Answer;

import java.util.List;

@Dao
public interface Question2AnswerDAO {

    @Insert
    void insert(Question2Answer t);

    @Delete
    void delete(Question2Answer t);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void update(Question2Answer t);

    @Query("SELECT * FROM question " +
            "INNER JOIN Question2Answer ON Question2Answer.questionId = Question.id " +
            "WHERE Question2Answer.answerId = :id ")
    List<Question> getQuestionsByAnswerId(final int id);

    @Query("SELECT * FROM Answer " +
            "INNER JOIN Question2Answer ON Answer.id = Question2Answer.answerId " +
            "WHERE Question2Answer.questionId = :id ")
    List<Answer> getAnswersByQuestion(final int id);
}
