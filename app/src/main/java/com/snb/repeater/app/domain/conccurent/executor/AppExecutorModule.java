package com.snb.repeater.app.domain.conccurent.executor;

import dagger.Module;
import dagger.Provides;

@Module
public class AppExecutorModule {

    @Provides
    public AppExecutor executor() {
        return new AppExecutorImpl();
    }
}
