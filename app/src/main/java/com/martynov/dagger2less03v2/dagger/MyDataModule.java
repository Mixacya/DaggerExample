package com.martynov.dagger2less03v2.dagger;

import android.content.Context;

import com.martynov.dagger2less03v2.MyDataApp;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by mihai on 5/28/2018.
 */
@Module
public class MyDataModule {

    private final Context mContext;
    private final List<String> mData = new ArrayList<>();

    public MyDataModule(final Context context) {
        this.mContext = context;
    }

    public void setData(final List<String> data) {
        if (data != null) {
            mData.addAll(data);
        }
    }

    @Singleton
    @Provides
    protected Context getContext() {
        return mContext;
    }

    @Singleton
    @Provides
    protected  List<String> getData() {
        return mData;
    }

    @Singleton
    @Provides
    protected MyDataModule getMyDataModule() {
        return this;
    }
}
