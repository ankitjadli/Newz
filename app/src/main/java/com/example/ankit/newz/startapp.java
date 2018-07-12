package com.example.ankit.newz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class startapp extends AppCompatActivity {
    Button getstarted;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startapp);
        getstarted = (Button) findViewById(R.id.setmeup);

        getstarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(startapp.this,signin.class);
                startActivity(intent);
            }
        });
    }
}
