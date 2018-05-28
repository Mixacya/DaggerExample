package com.martynov.dagger2less03v2.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.martynov.dagger2less03v2.MyDataApp;
import com.martynov.dagger2less03v2.dagger.DataComponent;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by mihai on 5/28/2018.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    @Inject
    Context mContext;
    @Inject
    List<String> mItems;

    private DataComponent mDataComponent;

    public MyAdapter() {
        mDataComponent = MyDataApp.mDataComponent();
        mDataComponent.inject(this);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, final int viewType) {
        final View view = LayoutInflater.from(/*parent.getContext()*/mContext).inflate(android.R.layout.simple_list_item_1, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        if (mItems != null) {
            holder.setInfo(mItems.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return mItems != null ? mItems.size() : -1;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(android.R.id.text1)
        TextView tvItem;

        public MyViewHolder(final View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setInfo(final String str) {
            if (!TextUtils.isEmpty(str)) {
                tvItem.setText(str);
            }
        }
    }
}
