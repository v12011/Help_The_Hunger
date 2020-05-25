package com.e.helpthehunger;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import java.lang.reflect.Member;
import java.util.HashMap;
import java.util.Map;

import static android.os.Build.ID;

public class MainActivity extends AppCompatActivity {


    EditText Name,Phone,Person,Address,Locality,State,Type;
    Button submit;
    FirebaseDatabase database;
    DatabaseReference ref;
    Donar donar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name     = (EditText) findViewById(R.id.fullName);
        Phone    = (EditText) findViewById(R.id.phone);
        Person   = (EditText) findViewById(R.id.no_of_person);
        Address  = (EditText) findViewById(R.id.address);
        Locality = (EditText) findViewById(R.id.locality);
        State    = (EditText) findViewById(R.id.state1);
        Type    = (EditText) findViewById(R.id.type);
        submit   = (Button)   findViewById(R.id.registerBtn);
        donar = new Donar();

        database = FirebaseDatabase.getInstance();
        ref = database.getReference("Donar");
        final String id = ref.push().getKey();



        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ref.addValueEventListener(new ValueEventListener(){


                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        //getValues();
                        //ref.child(id).child("id").setValue("Donar");
                        ref.child(id).child("name").setValue(Name.getText().toString());
                        ref.child(id).child("phone").setValue(Phone.getText().toString());
                        ref.child(id).child("person").setValue(Person.getText().toString());
                        ref.child(id).child("address").setValue(Address.getText().toString());
                        ref.child(id).child("locality").setValue(Locality.getText().toString());
                        ref.child(id).child("state").setValue(State.getText().toString());
                        ref.child(id).child("type").setValue(Type.getText().toString());
                        Toast.makeText(MainActivity.this, "Submitted...", Toast.LENGTH_LONG).show();
                        Intent thank = new Intent(MainActivity.this,ThankYou.class);
                        startActivity(thank);


                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });




        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.for_number_of_ppeople, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
    }


   /* private  void  getValues() {

        donar.setName(Name.getText().toString());
        donar.setPhone(Phone.getText().toString());
        donar.setPerson(Person.getText().toString());
        donar.setAddress(Address.getText().toString());
        donar.setLocality(Locality.getText().toString());
        donar.setState(State.getText().toString());
        donar.setType(Type.getText().toString());

    }*/


        @Override
        public boolean onCreateOptionsMenu(Menu menu){
            MenuInflater inflater = getMenuInflater();
            getMenuInflater().inflate(R.menu.menu,menu);
            return true;
        }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.agent:
                Intent home = new Intent(MainActivity.this,AgentLogin.class);
                startActivity(home);
                Toast.makeText(this, "You press Agent ", Toast.LENGTH_SHORT).show();

                return true;

            case R.id.contact:
               // Intent guest = new Intent(MainActivity.this,ContactUs.class);
               // startActivity(guest);
                Toast.makeText(this, "Contact ", Toast.LENGTH_SHORT).show();

                return true;



        }

        return super.onOptionsItemSelected(item);

    }

}


