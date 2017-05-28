package com.chrisventura.apps.dragger2mvp.view.presenter;

import com.chrisventura.apps.dragger2mvp.data.model.Post;

import java.util.List;

/**
 * Created by ventu on 27/5/2017.
 */

public class MainContract {

    public interface View {
        void setupList();
        void showPosts(List<Post> posts);
        void showError(String message);
        void showComplete();
    }

    public interface Presenter<T> {
        void setView(T view);
        void loadPosts();
    }
}
