package com.chrisventura.apps.dragger2mvp.data.modules;

import com.chrisventura.apps.dragger2mvp.data.net.PostApiService;
import com.chrisventura.apps.dragger2mvp.util.CustomScope;
import com.chrisventura.apps.dragger2mvp.view.presenter.MainContract;
import com.chrisventura.apps.dragger2mvp.view.presenter.MainPresenter;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by ventu on 27/5/2017.
 */

@Module
public class MainViewModule {
    private MainContract.View mView;

    public MainViewModule(MainContract.View view) {
        this.mView = view;
    }

    @Provides
    @CustomScope
    public MainContract.View providesMainView() {
        return mView;
    }

    @Provides
    @CustomScope
    public PostApiService providesPostApiService(Retrofit retrofit) {
        return retrofit.create(PostApiService.class);
    }


    @Provides
    @CustomScope
    public MainPresenter providesMainPresenter(PostApiService apiService) {
        return new MainPresenter(mView, apiService);
    }
}
