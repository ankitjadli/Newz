package com.example.ankit.newz;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class aboutus extends AppCompatActivity {
    Button githubprogile;
    Button Projectlink;
    Button xdlink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutus);

        githubprogile = (Button) findViewById(R.id.githubprofile);
        Projectlink = (Button) findViewById(R.id.projectlink);
        xdlink =(Button) findViewById(R.id.xdlink) ;

        githubprogile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/ankitjadli"));
                startActivity(browserIntent);
            }
        });

        Projectlink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/ankitjadli/Newz"));
                startActivity(browserIntent);
            }
        });

        xdlink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://drive.google.com/drive/folders/14soOvg7wxN6k-Btbo4O_RKHHso0A3YVc"));
                startActivity(browserIntent);
            }
        });
    }
}
