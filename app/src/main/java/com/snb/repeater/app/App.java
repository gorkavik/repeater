package com.snb.repeater.app;

import android.app.Application;

import com.snb.repeater.app.domain.context.Holder;
import com.snb.repeater.app.domain.dao.DAOFactory;
import com.snb.repeater.app.domain.model.Answer;
import com.snb.repeater.app.domain.model.Question;
import com.snb.repeater.app.ui.task.Task;

import java.util.ArrayList;
import java.util.List;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Holder.setContext(getApplicationContext());
        DAOFactory.getInstance();

        new Task<>(() -> {

            final List<Question> questions = new ArrayList<>();
            final Answer answer = new Answer(null, questions, "first_answer");

            ArrayList<Answer> answers = new ArrayList<>();
            final Question question = new Question(null, answers, "first_answer");


            DAOFactory.getInstance().insert();
            return null;
        }).execute();
    }
}
