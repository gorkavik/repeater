package com.snb.repeater.app.ui.task;

import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.concurrent.Callable;
import java.util.function.Consumer;

/**
 * Gorkavik_O
 * 24.02.2018.
 */

public class Task<T> extends AsyncTask<Void, T, T> {

    private final Callable<T> callable;
    private final Consumer<T> consumer;

    public Task(final Callable<T> callable, final Consumer<T> consumer) {
        this.callable = callable;
        this.consumer = consumer;
    }

    @Override
    protected T doInBackground(final Void... voids) {
        try {
            return callable.call();
        } catch (Exception e) {
            return null;
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onPostExecute(final T t) {
        consumer.accept(t);
    }
}
