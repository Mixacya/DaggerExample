package com.martynov.dagger2less03v2;

import android.app.Application;

import com.martynov.dagger2less03v2.dagger.DaggerDataComponent;
import com.martynov.dagger2less03v2.dagger.DataComponent;
import com.martynov.dagger2less03v2.dagger.MyDataModule;

/**
 * Created by mihai on 5/28/2018.
 */

public class MyDataApp extends Application {

    private static DataComponent mComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    public static DataComponent mDataComponent() {
        return mComponent;
    }

    private void init() {
        mComponent = DaggerDataComponent.builder()
                .myDataModule(new MyDataModule(this))
                .build();
    }
}
