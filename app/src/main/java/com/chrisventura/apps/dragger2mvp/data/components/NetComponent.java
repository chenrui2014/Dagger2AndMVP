package com.chrisventura.apps.dragger2mvp.data.components;

import com.chrisventura.apps.dragger2mvp.data.modules.AppModule;
import com.chrisventura.apps.dragger2mvp.data.modules.NetModule;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by ventu on 27/5/2017.
 */

@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface NetComponent {
    Retrofit retrofit();
}
