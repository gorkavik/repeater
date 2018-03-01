package com.snb.repeater.app.domain.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.List;

import lombok.Data;
import lombok.Getter;

@Data
@Entity
public class Answer {

    @PrimaryKey(autoGenerate = true)
    @Getter
    private final Long id;

    @Getter
    private final List<Question> questions;

    @Getter
    private final String answer;
}
