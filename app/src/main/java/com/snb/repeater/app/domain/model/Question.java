package com.snb.repeater.app.domain.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.List;

import lombok.Data;
import lombok.Getter;

@Data
@Entity
public class Question {

    @PrimaryKey(autoGenerate = true)
    @Getter
    private final Long id;

    @Getter
    private final List<Answer> answers;

    @Getter
    private final String question;
}
