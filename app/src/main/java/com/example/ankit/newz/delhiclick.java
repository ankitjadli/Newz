package com.example.ankit.newz;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class delhiclick extends AppCompatActivity {
    private DatabaseReference mdatabse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delhiclick);
        mdatabse = FirebaseDatabase.getInstance().getReference().child("Data");
        mdatabse.keepSynced(true);
        final String news_id = getIntent().getStringExtra("news_id");

        mdatabse.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String   image = dataSnapshot.child(news_id).child("image").getValue().toString();
                String   title = dataSnapshot.child(news_id).child("title").getValue().toString();
                String   description = dataSnapshot.child(news_id).child("description").getValue().toString();
                TextView news_title = (TextView) findViewById(R.id.onclicknewstitle);
                ImageView news_Image = (ImageView) findViewById(R.id.newsimg);
                TextView news_description = (TextView) findViewById(R.id.description);

                news_title.setText(title);
                news_description.setText(description);
                Picasso.get().load(image).placeholder(R.drawable.ic_launcher_background).into(news_Image);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }
}
