package com.snb.repeater.app;

import android.app.Application;

import com.snb.repeater.app.domain.context.Holder;
import com.snb.repeater.app.domain.dao.DAOFactory;
import com.snb.repeater.app.domain.model.DB;
import com.snb.repeater.app.ui.task.Task;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Holder.setContext(getApplicationContext());
        DAOFactory.getInstance();

        new Task<>(() -> {
            final DB db = new DB();
            db.setId(1);
            db.setQuestion("first_question");
            db.setAnswer("first_answer");
            DAOFactory.getInstance().insert(db);
            return null;
        }).execute();
    }
}
