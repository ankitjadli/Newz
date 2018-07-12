package com.example.ankit.newz;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.iid.FirebaseInstanceId;

public class signin extends AppCompatActivity {

    Button signup;
    EditText email;
    EditText pass;
    Button login ;
    FirebaseAuth mauth;
    private ProgressDialog mprogressdialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        email=(EditText)findViewById(R.id.emailtext);
        pass=(EditText)findViewById(R.id.passwordtext);
        login=(Button)findViewById(R.id.signin);
        mauth=FirebaseAuth.getInstance();
        mprogressdialog=new ProgressDialog(this);
        mprogressdialog.setTitle("Logging In");
        mprogressdialog.setMessage("Please wait while we log you in");
        mprogressdialog.setCanceledOnTouchOutside(false);


        signup = (Button) findViewById(R.id.signuofromin);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(signin.this, com.example.ankit.newz.signup.class);
                startActivity(intent);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String passcode = pass.getText().toString();
                final String emaill=email.getText().toString();
                mprogressdialog.show();

                if(!TextUtils.isEmpty(passcode)&&!TextUtils.isEmpty(emaill))
                {
                    mauth.signInWithEmailAndPassword(emaill,passcode).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful())
                            {
                                mprogressdialog.dismiss();
                                Intent loginsucess = new Intent(signin.this,MainActivity.class);
                                startActivity(loginsucess);
                                finish();

                            }
                            else
                            {
                                mprogressdialog.hide();
                                String error = task.getException().getMessage();
                                Toast.makeText(signin.this,""+error,Toast.LENGTH_LONG).show();
                            }
                        }

                    });


                }
                else
                {
                    if (TextUtils.isEmpty(passcode))
                    {
                        mprogressdialog.hide();
                        Toast.makeText(signin.this,"Enter Password",Toast.LENGTH_LONG).show();
                    }
                    else {
                        mprogressdialog.hide();
                        Toast.makeText(signin.this,"Enter Email",Toast.LENGTH_LONG).show();
                    }
                }



            }
        });



    }
}
