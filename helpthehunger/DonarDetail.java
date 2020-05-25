package com.e.helpthehunger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DonarDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donar_detail);


        Intent intent = getIntent();
        Donar donar = intent.getParcelableExtra("Donar");

        String line1 = donar.getName();
        String line2 = donar.getType();
        String line3 = donar.getPerson();
        String line4 = donar.getAddress();
        String line5 = donar.getLocality();
        String line6 = donar.getState();
        String line7 = donar.getPhone();

        TextView textView1 = findViewById(R.id.name);
        textView1.setText(line1);

        TextView textView2 = findViewById(R.id.type);
        textView2.setText(line2);

        TextView textView3 = findViewById(R.id.quantity);
        textView3.setText(line3);

        TextView textView4 = findViewById(R.id.add1);
        textView4.setText(line4);

        TextView textView5 = findViewById(R.id.locality);
        textView5.setText(line5);

        TextView textView6 = findViewById(R.id.state);
        textView6.setText(line6);

        TextView textView7 = findViewById(R.id.phone);
        textView7.setText(line7);

    }

}
