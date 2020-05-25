package com.e.helpthehunger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class AgentLogin extends AppCompatActivity {

    //EditText mEmail,mPassword;
    Button LoginBtn;
    TextView mCreateBtn,forgotTextLink;
    //ProgressBar progressBar;
    //FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agent_login);

        //mEmail = findViewById(R.id.Email);
        //mPassword = findViewById(R.id.password);
        //progressBar = findViewById(R.id.progressBar);
        //fAuth = FirebaseAuth.getInstance();
        LoginBtn = findViewById(R.id.loginBtn);
        mCreateBtn = findViewById(R.id.createText);
        //forgotTextLink = findViewById(R.id.forgotPassword);


        mCreateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),AgentSignup.class));
            }
        });

        LoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),AgentHome.class));
            }
        });
    }
}
