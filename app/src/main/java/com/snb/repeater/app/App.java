package com.snb.repeater.app;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.snb.repeater.app.domain.db.DBAbstract;

public class App extends Application {
    private static DBAbstract db;

//db instance
@Override
    public void onCreate() {
        super.onCreate();
         db = Room.databaseBuilder(getApplicationContext(), DBAbstract.class, "data-database")
                //.allowMainThreadQueries()
                .build();
    }

    public  static DBAbstract getDBInstance() { return db;}
}
