package com.chrisventura.apps.dragger2mvp;

import android.app.Application;
import android.util.Log;

import com.chrisventura.apps.dragger2mvp.data.components.DaggerNetComponent;
import com.chrisventura.apps.dragger2mvp.data.components.NetComponent;
import com.chrisventura.apps.dragger2mvp.data.modules.AppModule;
import com.chrisventura.apps.dragger2mvp.data.modules.NetModule;

/**
 * Created by ventu on 27/5/2017.
 */

public class Dagger2MvpApplication extends Application {

    private static final String TAG = "Dagger2MvpApplication";
    NetComponent mNetComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "Application created.");

        mNetComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule("http://jsonplaceholder.typicode.com/"))
                .build();

    }

    public NetComponent getNetComponent() {
        return mNetComponent;
    }
}
