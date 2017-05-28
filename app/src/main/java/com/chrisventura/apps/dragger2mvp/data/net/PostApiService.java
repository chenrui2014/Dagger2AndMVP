package com.chrisventura.apps.dragger2mvp.data.net;


import com.chrisventura.apps.dragger2mvp.data.model.Post;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by ventu on 28/5/2017.
 */

public interface PostApiService {
    @GET("posts")
    Observable<List<Post>> getPostList();
}
