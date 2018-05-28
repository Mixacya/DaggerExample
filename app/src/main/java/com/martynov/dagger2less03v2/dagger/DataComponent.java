package com.martynov.dagger2less03v2.dagger;

import android.widget.BaseAdapter;

import com.martynov.dagger2less03v2.adapter.MyAdapter;
import com.martynov.dagger2less03v2.ui.BaseActivity;
import com.martynov.dagger2less03v2.ui.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by mihai on 5/28/2018.
 */
@Singleton
@Component(modules = MyDataModule.class)
public interface DataComponent {
    void inject(MainActivity activity);
    void inject(MyAdapter adapter);
}
