package com.snb.repeater.app.domain.context;

import android.content.Context;

/**
 * Gorkavik_O
 * 24.02.2018.
 */

public class Holder {

    private static Context context;

    public static void setContext(Context context) {
        Holder.context = context;
    }

    public static Context getContext() {
        return context;
    }
}
