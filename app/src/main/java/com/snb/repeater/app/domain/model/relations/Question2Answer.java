package com.snb.repeater.app.domain.model.relations;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import com.snb.repeater.app.domain.model.entity.Answer;
import com.snb.repeater.app.domain.model.entity.Question;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Question2Answer {
    @PrimaryKey(autoGenerate = true)
    private Long id;
    @ForeignKey(entity = Answer.class, parentColumns = "id", childColumns = "answerId")
    private Long answerId;
    @ForeignKey(entity = Question.class, parentColumns = "id", childColumns = "questionId")
    private Long questionId;
}
