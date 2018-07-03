package com.snb.repeater.app.domain.conccurent.task;

import android.os.AsyncTask;

import java.util.concurrent.Callable;
import java.util.function.Consumer;

public class Task<T> extends AsyncTask<T, T, T> {

    private final Runnable onPreExecute;
    private final Callable<T> inBackground;
    private final Consumer<T> onPostExecute;

    private Task(final Runnable onPreExecute, final Callable<T> inBackground, final Consumer<T> onPostExecute) {
        this.onPreExecute = onPreExecute;
        this.inBackground = inBackground;
        this.onPostExecute = onPostExecute;
    }

    public Task(final Callable<T> inBackground, final Consumer<T> onPostExecute) {
        this(null, inBackground, onPostExecute);
    }

    public Task(final Callable<T> inBackground) {
        this(null, inBackground, null);
    }

    @Override
    protected void onPreExecute() {
        if (onPreExecute != null) {
            onPreExecute.run();
        }
    }

    @Override
    protected T doInBackground(final T... args) {
        try {
            return inBackground.call();
        } catch (final Exception e) {
            return null;
        }
    }

    @Override
    protected void onPostExecute(final T t) {
        if (onPostExecute != null) {
            onPostExecute.accept(t);
        }
    }
}
