package com.chrisventura.apps.dragger2mvp.view.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.chrisventura.apps.dragger2mvp.Dagger2MvpApplication;
import com.chrisventura.apps.dragger2mvp.R;
import com.chrisventura.apps.dragger2mvp.data.components.DaggerMainViewComponent;
import com.chrisventura.apps.dragger2mvp.data.model.Post;
import com.chrisventura.apps.dragger2mvp.data.modules.MainViewModule;
import com.chrisventura.apps.dragger2mvp.view.presenter.MainContract;
import com.chrisventura.apps.dragger2mvp.view.presenter.MainPresenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainContract.View {
    @Inject
    MainPresenter mPresenter;

    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DaggerMainViewComponent.builder()
                .netComponent(
                        ((Dagger2MvpApplication) getApplication())
                                .getNetComponent())
                .mainViewModule(new MainViewModule(this))
                .build()
                .inject(this);

        setupList();
        mPresenter.loadPosts();

    }

    @Override
    public void setupList() {
        mListView = (ListView) findViewById(R.id.listview);
    }

    @Override
    public void showPosts(List<Post> posts) {

        ArrayList<String> list = new ArrayList<>();

        for (Post post : posts) {
            list.add(post.getTitle());
        }

        mListView.setAdapter(
                new ArrayAdapter<String>(
                        this, android.R.layout.simple_list_item_1, list));
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showComplete() {
        Toast.makeText(this, "Completed", Toast.LENGTH_SHORT).show();
    }
}
