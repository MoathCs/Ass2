package com.example.assignmenttowapp;


import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView text1;
    private ImageView img1;
    private ImageView img2;


    private Animation animation;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1=findViewById(R.id.toptext);
        animation= AnimationUtils.loadAnimation(this,R.anim.anim);
        img1=findViewById(R.id.picAnmi1);
        img2=findViewById(R.id.picAnmi2);
        text1.setAnimation(animation);
        img1.setAnimation(animation);
        img2.setAnimation(animation);

        runHand();
    }
    private void ActTow(){
        Intent intent = new Intent(this,MainActivity2.class);
        startActivity(intent);
    }
    private void runHand(){
        final Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                ActTow();
            }


        };
        handler.postDelayed(runnable,7000);
    }


}