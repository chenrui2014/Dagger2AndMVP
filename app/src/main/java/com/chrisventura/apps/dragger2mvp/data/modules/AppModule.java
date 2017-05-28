package com.chrisventura.apps.dragger2mvp.data.modules;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ventu on 27/5/2017.
 */

@Module
public class AppModule {
    Application mApplication;

    public AppModule(Application app) {
        this.mApplication = app;
    }

    @Provides @Singleton
    Application providesApplication() {
        return mApplication;
    }
}
