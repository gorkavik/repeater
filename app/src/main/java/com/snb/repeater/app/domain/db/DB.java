package com.snb.repeater.app.domain.db;


import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;


@Entity
public class DB {
//    Assigment:
//    Read: https://habrahabr.ru/post/336196/
//    Understand: what is Room? and what for it?
//    Create entity, dao for it.
//    Implement CRUD methods (create, read, update, delete)
//    *** Add tests for each method
//    info : https://stfalcon.com/ru/blog/post/simple-unit-tests-for-android


    @NonNull
    @PrimaryKey private int id;
    private String question;
    private String answer;

// get/set for question_id
    public int getId() { return id; }

    public void setId(int question_id) {
        this.id = question_id;
    }

// get/set for question
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

// get/set for answer
    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }


}
