package com.snb.repeater.app;

import android.app.Application;

import com.snb.repeater.app.domain.conccurent.executor.AppExecutorModule;
import com.snb.repeater.app.domain.dao.DAOModule;
import com.snb.repeater.app.domain.model.entity.Answer;
import com.snb.repeater.app.domain.model.entity.Question;
import com.snb.repeater.app.domain.model.relations.Question2Answer;
import com.snb.repeater.app.ui.dagger.AppComponent;
import com.snb.repeater.app.ui.dagger.DaggerAppComponent;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        final AppComponent component = DaggerAppComponent
                .builder()
                .dAOModule(new DAOModule(this))
                .appExecutorModule(new AppExecutorModule())
                .build();

        component
                .getAppExecutor()
                .submit(() -> {
                    component.getAnswerDao().insert(new Answer(null, "first_answer"));
                    component.getQuestionDao().insert(new Question(null, "first_answer"));
                    component.getQuestion2AnswerDao().insert(new Question2Answer(null, 1L, 1L));
                });
    }
}
