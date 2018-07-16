package com.example.ankit.newz;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class startapp extends AppCompatActivity {
    Button getstarted;
    Animation uptodown,downtoup,lefttoright,righttoleft;
    ImageView bottomimg,leftimage,rightimage;

    TextView appinfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startapp);

        leftimage = (ImageView) findViewById(R.id.tempart);
        rightimage = (ImageView) findViewById(R.id.tempartright);
        bottomimg =(ImageView) findViewById(R.id.bootommostimg);
        appinfo = (TextView) findViewById(R.id.appname);
        getstarted = (Button) findViewById(R.id.setmeup);

        uptodown = AnimationUtils.loadAnimation(this,R.anim.uptodown);
        downtoup = AnimationUtils.loadAnimation(this,R.anim.downtoup);
        lefttoright = AnimationUtils.loadAnimation(this,R.anim.lefttoright);
        righttoleft=AnimationUtils.loadAnimation(this,R.anim.righttoleft);

        leftimage.setAnimation(lefttoright);
        rightimage.setAnimation(righttoleft);
        bottomimg.setAnimation(downtoup);
        getstarted.setAnimation(righttoleft);
        appinfo.setAnimation(lefttoright);

        getstarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(startapp.this,signin.class);
                startActivity(intent);
            }
        });
    }
}
