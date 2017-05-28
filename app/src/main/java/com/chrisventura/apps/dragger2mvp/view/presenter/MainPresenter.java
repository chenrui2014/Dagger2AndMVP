package com.chrisventura.apps.dragger2mvp.view.presenter;

import com.chrisventura.apps.dragger2mvp.data.model.Post;
import com.chrisventura.apps.dragger2mvp.data.net.PostApiService;

import java.util.List;

import javax.inject.Inject;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by ventu on 28/5/2017.
 */

public class MainPresenter implements MainContract.Presenter<MainContract.View> {
    MainContract.View mView;
    PostApiService apiService;

    @Inject MainPresenter(PostApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public void setView(MainContract.View view) {
        this.mView = view;
    }

    @Override
    public void loadPosts() {
        apiService.getPostList()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<List<Post>>() {
                    @Override
                    public void onCompleted() {
                        mView.showComplete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        mView.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(List<Post> posts) {
                        mView.showPosts(posts);
                    }
                });
    }
}
