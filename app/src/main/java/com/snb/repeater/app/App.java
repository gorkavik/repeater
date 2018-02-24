package com.snb.repeater.app;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.snb.repeater.app.domain.context.Holder;
import com.snb.repeater.app.domain.db.DBAbstract;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Holder.setContext(getApplicationContext());
    }
}
