package com.martynov.dagger2less03v2.ui;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.martynov.dagger2less03v2.MyDataApp;
import com.martynov.dagger2less03v2.R;
import com.martynov.dagger2less03v2.adapter.MyAdapter;
import com.martynov.dagger2less03v2.dagger.DataComponent;
import com.martynov.dagger2less03v2.dagger.MyDataModule;
import com.martynov.dagger2less03v2.ui.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import dagger.Provides;

public class MainActivity extends BaseActivity {

    @BindView(R.id.rv_list)
    RecyclerView rvItems;

    @Inject
    Context mContext;
    @Inject
    List<String> mData;

    private DataComponent mDataComponent;

    private MyAdapter mAdapter;

    @Override
    protected int getViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onViewCreated() {
        mDataComponent = MyDataApp.mDataComponent();
        mDataComponent.inject(this);
        rvItems.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
        mAdapter = new MyAdapter();
        rvItems.setAdapter(mAdapter);
        addValues();
    }

    private void addValues() {
        mData.add("Franklin");
        mData.add("Michael");
        mData.add("Trevor");
        mData.add("Somebody");
        mData.add("Batman");
        mAdapter.notifyDataSetChanged();
    }
}
