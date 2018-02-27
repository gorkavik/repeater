package com.snb.repeater.app.ui.task;

import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.concurrent.Callable;
import java.util.function.Consumer;

public class Task<T> extends AsyncTask<Void, T, T> {

    private final Callable<T> callable;
    private final Consumer<T> consumer;

    public Task(final Callable<T> callable, final Consumer<T> consumer) {
        this.callable = callable;
        this.consumer = consumer;
    }

    public Task(final Callable<T> callable) {
        this(callable, null);
    }

    @Override
    protected T doInBackground(final Void... voids) {
        try {
            return callable.call();
        } catch (final Exception e) {
            return null;
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onPostExecute(final T t) {
        if (consumer != null) {
            consumer.accept(t);
        }
    }
}
