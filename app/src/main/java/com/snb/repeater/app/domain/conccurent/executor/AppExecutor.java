package com.snb.repeater.app.domain.conccurent.executor;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.function.Consumer;

public interface AppExecutor {
    Future submit(Callable callable);

    void submit(Runnable runnable);

    <T> void submitTask(final Callable<T> callable, final Consumer<T> consumer);
}
