package com.snb.repeater.app.domain.conccurent.executor;

import com.snb.repeater.app.domain.conccurent.task.Task;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Consumer;

public class AppExecutorImpl implements AppExecutor {

    private final ExecutorService service = Executors.newFixedThreadPool(Runtime
            .getRuntime()
            .availableProcessors());

    @Override
    public Future submit(final Callable callable) {
        return service.submit(callable);
    }

    @Override
    public void submit(final Runnable runnable) {
        service.submit(runnable);
    }

    @Override
    public <T> void submitTask(final Callable<T> callable, final Consumer<T> consumer) {
        new Task<>(callable, consumer).executeOnExecutor(service);
    }
}
