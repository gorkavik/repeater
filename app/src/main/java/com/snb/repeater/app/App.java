package com.snb.repeater.app;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.snb.repeater.app.domain.db.DBAbstract;

public class App extends Application {

    private static App instance;
    private DBAbstract db;

    public static App getInstance() {
        return instance;
    }

//db instance
@Override
    public void onCreate() {
        super.onCreate();
        instance = this;
         db = Room.databaseBuilder(getApplicationContext(), DBAbstract.class, "data-database")
                //.allowMainThreadQueries()
                .build();
    }

    public DBAbstract getDBInstance() { return db;}
}
