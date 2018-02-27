package com.snb.repeater.app.domain.context;

import android.content.Context;

public class Holder {

    private static Context context;

    public static void setContext(final Context context) {
        Holder.context = context;
    }

    public static Context getContext() {
        if (context == null) {
            throw new IllegalStateException("Context not set");
        }

        return context;
    }
}
