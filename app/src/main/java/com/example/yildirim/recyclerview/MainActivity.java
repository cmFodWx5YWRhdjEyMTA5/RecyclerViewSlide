package com.example.yildirim.recyclerview;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Button;

import com.example.yildirim.recyclerview.adapter.SimpleRecyclerAdapter;


public class MainActivity extends AppCompatActivity {

    Button btnDown, btnUp, btnRight, btnLeft;
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDown = (Button) findViewById(R.id.btnDown);
        btnUp = (Button) findViewById(R.id.btnUp);
        btnLeft = (Button) findViewById(R.id.btnLeft);
        btnRight = (Button) findViewById(R.id.btnRight);


        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        btnDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                runAnimation(recyclerView, 0);
            }
        });

        btnUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                runAnimation(recyclerView, 1);

            }
        });

        btnLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                runAnimation(recyclerView, 2);

            }
        });

        btnRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                runAnimation(recyclerView, 3);

            }
        });



    }

    private void runAnimation(RecyclerView recyclerView, int type) {

        Context context =recyclerView.getContext();
        LayoutAnimationController controller =null;

        if (type == 0)
            controller = AnimationUtils.loadLayoutAnimation(context, R.anim.layout_to_down);

        else if(type == 1)
            controller = AnimationUtils.loadLayoutAnimation(context, R.anim.layout_to_up);


        else if(type == 2)
            controller = AnimationUtils.loadLayoutAnimation(context, R.anim.layout_slide_right);

        else if(type == 3)
            controller = AnimationUtils.loadLayoutAnimation(context, R.anim.layout_slide_left);


        SimpleRecyclerAdapter adapter = new SimpleRecyclerAdapter();
        recyclerView.setAdapter(adapter);

        //set anim
        recyclerView.setLayoutAnimation(controller);
        recyclerView.getAdapter().notifyDataSetChanged();
        recyclerView.scheduleLayoutAnimation();
    }
}
