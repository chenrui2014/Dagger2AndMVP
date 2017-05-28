package com.chrisventura.apps.dragger2mvp.data.components;

import com.chrisventura.apps.dragger2mvp.data.modules.MainViewModule;
import com.chrisventura.apps.dragger2mvp.view.ui.MainActivity;
import com.chrisventura.apps.dragger2mvp.util.CustomScope;

import dagger.Component;

/**
 * Created by ventu on 27/5/2017.
 */

@CustomScope
@Component(dependencies = NetComponent.class, modules = MainViewModule.class)
public interface MainViewComponent {
    void inject(MainActivity activity);
}
