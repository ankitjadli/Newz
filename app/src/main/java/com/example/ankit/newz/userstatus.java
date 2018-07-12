package com.example.ankit.newz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class userstatus extends AppCompatActivity{

    FirebaseUser crrntuser;
    FirebaseAuth matuth;
    String user;

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentuser;
        matuth=FirebaseAuth.getInstance();
        crrntuser = matuth.getCurrentUser();
        if (crrntuser==null)
        {
            Intent gotoregisteractivity = new Intent(userstatus.this,startapp.class);
            startActivity(gotoregisteractivity);
            finish();
        }
        else
        {
            Intent stayandchat = new Intent(userstatus.this,MainActivity.class);
            startActivity(stayandchat);
            finish();

        }
    }
}
