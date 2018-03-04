package com.snb.repeater.app;

import android.app.Application;

import com.snb.repeater.app.domain.context.Holder;
import com.snb.repeater.app.domain.model.entity.Answer;
import com.snb.repeater.app.domain.model.entity.Question;
import com.snb.repeater.app.domain.model.relations.Question2Answer;
import com.snb.repeater.app.ui.task.Task;

import static com.snb.repeater.app.domain.dao.abstr.DAOFactory.getINSTANCE;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Holder.setContext(getApplicationContext());

        new Task<>(() -> {
            getINSTANCE().getAnswerDao().insert(new Answer(null, "first_answer"));
            getINSTANCE().getQuestionDao().insert(new Question(null, "first_answer"));
            getINSTANCE().getQuestion2AnswerDao().insert(new Question2Answer(null, 1L, 1L));
            return null;
        }).execute();
    }
}
