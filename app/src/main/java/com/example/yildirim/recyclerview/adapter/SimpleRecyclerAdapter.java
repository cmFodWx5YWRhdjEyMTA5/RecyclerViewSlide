package com.example.yildirim.recyclerview.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.yildirim.recyclerview.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yildirim on 5.01.2018.
 */

public class SimpleRecyclerAdapter extends RecyclerView.Adapter<SimpleRecyclerAdapter.SimpleViewHolder> {


    List<Integer> dataSource;
    public SimpleRecyclerAdapter() {

        dataSource = new ArrayList<>();
        for (int i=0; i<10;i++){
            dataSource.add(i);
        }

    }

    @Override
    public SimpleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_item, parent,false);
        return new SimpleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SimpleViewHolder holder, int position) {
            holder.textView.setText(String.valueOf(dataSource.get(position)));
    }

    @Override
    public int getItemCount() {
        return dataSource.size();
    }

    public static class SimpleViewHolder extends RecyclerView.ViewHolder {

        public TextView textView;

        public SimpleViewHolder(View itemView) {
            super(itemView);

            textView = (TextView) itemView.findViewById(R.id.textView);


        }
    }


}
