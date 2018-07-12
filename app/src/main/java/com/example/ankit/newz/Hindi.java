package com.example.ankit.newz;


import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.Date;
import java.util.Random;

import de.hdodenhof.circleimageview.CircleImageView;


public class Hindi extends Fragment {

    private RecyclerView muserslist;
    private View mViewmain;


    public Hindi() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mViewmain = inflater.inflate(R.layout.fragment_hindi, container, false);
        muserslist =(RecyclerView)mViewmain.findViewById(R.id.hindifragmentview);
        muserslist.setHasFixedSize(true);
        muserslist.setLayoutManager(new LinearLayoutManager(getContext()));

        return mViewmain;


    }

    @Override
    public void onStart() {
        super.onStart();
        startListening();
    }
    public void startListening(){
        final DatabaseReference mdatabase;
        mdatabase = FirebaseDatabase.getInstance().getReference();

        Query query = FirebaseDatabase.getInstance()
                .getReference()
                .child("Hindi")
                .limitToLast(50);
        query.keepSynced(true);


        FirebaseRecyclerOptions<news> options =
                new FirebaseRecyclerOptions.Builder<news>()
                        .setQuery(query, news.class)
                        .build();

        FirebaseRecyclerAdapter adapter = new FirebaseRecyclerAdapter<news , Hindi.UserViewHolder>(options) {
            @Override
            public Hindi.UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                // Create a new instance of the ViewHolder, in this case we are using a custom
                // layout called R.layout.message for each item
                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.newsbasiciclayout, parent, false);

                return new Hindi.UserViewHolder(view);
            }

            @Override
            protected void onBindViewHolder(@NonNull final Hindi.UserViewHolder holder, int i, @NonNull news user) {

                holder.setDescription(user.getDescription(),user.getImage());
                holder.setTitle(user.getTitle());
                final String news_id = getRef(i).getKey();
                holder.mView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent showfrofile = new Intent(getContext(),hindiclick.class);
                        showfrofile.putExtra("news_id",news_id);
                        startActivity(showfrofile);
                    }
                });

            }


        };
        muserslist.setAdapter(adapter);
        adapter.startListening();


    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {
        View mView;


        public UserViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
        }

        public void setDescription(String description,String image) {
            CircleImageView newsview;
            newsview = (CircleImageView) mView.findViewById(R.id.rImageView);
            Picasso.get().load(image).placeholder(R.drawable.whitecircle).into(newsview);

        }
        public void setTitle(String description) {
            TextView desc =(TextView) mView.findViewById(R.id.newstitle);
            desc.setText(description);
        }





    }
}
