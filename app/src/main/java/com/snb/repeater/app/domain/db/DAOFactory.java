package com.snb.repeater.app.domain.db;

import android.arch.persistence.room.Room;

import com.snb.repeater.app.domain.context.Holder;
import com.snb.repeater.app.ui.activity.MainActivity;

/**
 * Gorkavik_O
 * 24.02.2018.
 */

public class DAOFactory {

    private final static DBDao instance = Room
            .databaseBuilder(Holder.getContext(), DBAbstract.class, "data-database")
            .build()
            .getDBDao();

    public DBDao getInstance() {
        return instance;
    }
}
