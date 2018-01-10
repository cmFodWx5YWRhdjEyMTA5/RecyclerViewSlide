package com.example.yildirim.recyclerview;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import com.example.yildirim.recyclerview.adapter.SimpleRecyclerAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recyclerView)   RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

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

    @OnClick(R.id.btnDown)
    public void btnDown(){
        runAnimation(recyclerView, 0);

    }
    @OnClick(R.id.btnUp)
    public void btnUp(){
        runAnimation(recyclerView, 1);

    }
    @OnClick(R.id.btnLeft)
    public void btnLeft(){
        runAnimation(recyclerView, 2);

    }
    @OnClick(R.id.btnRight)
    public void btnRight(){
        runAnimation(recyclerView, 3);

    }
}
