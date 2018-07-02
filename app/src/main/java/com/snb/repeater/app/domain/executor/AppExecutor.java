package com.snb.repeater.app.domain.executor;

import java.util.concurrent.Callable;
import java.util.function.Consumer;

public interface AppExecutor<T> {
    void submit(Callable callable);

    void submit(Runnable runnable);

    void submitTask(final Callable<T> callable, final Consumer<T> consumer);
}
