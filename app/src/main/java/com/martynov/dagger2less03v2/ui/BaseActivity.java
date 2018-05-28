package com.martynov.dagger2less03v2.ui;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.martynov.dagger2less03v2.dagger.DataComponent;
import com.martynov.dagger2less03v2.dagger.MyDataModule;

import butterknife.ButterKnife;

/**
 * Created by mihai on 5/28/2018.
 */

public abstract class BaseActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getViewId());
        ButterKnife.bind(this);
        onViewCreated();
    }

    @LayoutRes
    protected abstract int getViewId();

    protected abstract void onViewCreated();
}
