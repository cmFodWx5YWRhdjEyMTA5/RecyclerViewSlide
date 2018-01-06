package com.example.yildirim.recyclerview.adapter;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.example.yildirim.recyclerview.MainActivity;
import com.example.yildirim.recyclerview.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Yildirim on 5.01.2018.
 */

public class SimpleRecyclerAdapter extends RecyclerView.Adapter<SimpleRecyclerAdapter.SimpleViewHolder> {

    List<String> dataSource;
    List<Character> dataSourceLetter;

    public SimpleRecyclerAdapter() {

        String[] thisIsAStringArray = new String[6];
        thisIsAStringArray[0] = "Ali";
        thisIsAStringArray[1] = "Veli";
        thisIsAStringArray[2] = "Yıldırım";
        thisIsAStringArray[3] = "Mesut ";
        thisIsAStringArray[4] = "Zozan";


        dataSource = new ArrayList<>();
        dataSourceLetter = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            dataSource.add(thisIsAStringArray[i]);

            String firstLetter = thisIsAStringArray[i].toString();
            char first = firstLetter.charAt(0);
            dataSourceLetter.add(first);
        }

    }

    @Override
    public SimpleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_item, parent, false);
        return new SimpleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SimpleViewHolder holder, int position) {
        holder.textView.setText(String.valueOf(dataSource.get(position)));

        Random rnd = new Random();
        int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        TextDrawable drawable = TextDrawable.builder()
                .buildRoundRect(String.valueOf(dataSourceLetter.get(position)), color,100);

        holder.image.setImageDrawable(drawable);
    }

    @Override
    public int getItemCount() {
        return dataSource.size();
    }

    public static class SimpleViewHolder extends RecyclerView.ViewHolder {

        public TextView textView;
        public ImageView image;

        public SimpleViewHolder(View itemView) {
            super(itemView);

            textView = (TextView) itemView.findViewById(R.id.textView);
             image = (ImageView) itemView.findViewById(R.id.image_view);

        }
    }


}
