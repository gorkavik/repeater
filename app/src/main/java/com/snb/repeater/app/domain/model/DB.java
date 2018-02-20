package com.snb.repeater.app.domain.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import lombok.Data;

@Data
@Entity
public class DB {
    //    Assigment:
    //    Read: https://habrahabr.ru/post/336196/
    //    Understand: what is Room? and what for it?
    //    Create entity, dao for it.
    //    Implement CRUD methods (create, read, update, delete)
    //    *** Add tests for each method
    //    info : https://stfalcon.com/ru/blog/post/simple-unit-tests-for-android
    @PrimaryKey
    private int id;
    private String question;
    private String answer;
}
