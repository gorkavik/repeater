package com.snb.repeater.app.domain.dao;

import android.arch.persistence.room.Room;

import com.snb.repeater.app.domain.context.Holder;

public class DAOFactory {

    private final static DAO INSTANCE = Room
            .databaseBuilder(Holder.getContext(), DAOAbstract.class, "data-database")
            .build()
            .getDBDao();

    public static DAO getInstance() {
        return INSTANCE;
    }
}
