package com.e.helpthehunger;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.ArrayList;

import static androidx.appcompat.widget.ResourceManagerInternal.get;

public class AgentHome extends AppCompatActivity  implements Adapter.Listner {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    FirebaseDatabase database;
    DatabaseReference reff;
    public Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agent_home);

        database = FirebaseDatabase.getInstance();
        reff = database.getInstance().getReference("Donar");

        recyclerView = (RecyclerView) findViewById(R.id.rc);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        FirebaseRecyclerOptions<Donar> options = new FirebaseRecyclerOptions.Builder<Donar>()
                .setQuery(reff, Donar.class)
                .build();

        //adapter = new Adapter(Context ,@NonNull FirebaseRecyclerOptions<Donar> options, Adapter.Listner );
        recyclerView.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        getMenuInflater().inflate(R.menu.profile, menu);
        MenuItem item = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.search:
                //Intent profile = new Intent(AgentHome.this,AgentProfile.class);
                //startActivity(profile);
                Toast.makeText(this, "Search ", Toast.LENGTH_SHORT).show();

                return true;

            case R.id.profile:
                Intent profile = new Intent(AgentHome.this, AgentProfile.class);
                startActivity(profile);
                Toast.makeText(this, "You press Profile ", Toast.LENGTH_SHORT).show();

                return true;

            case R.id.logout:
                Intent out = new Intent(AgentHome.this, MainActivity.class);
                startActivity(out);
                Toast.makeText(this, "You have been Logout ", Toast.LENGTH_SHORT).show();

                return true;
        }

        return super.onOptionsItemSelected(item);

    }


    @Override
    protected void onStart() {
        super.onStart();
    }


    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    public void click(int position) {

    }

/*
    @Override
    public void click(int position) {

        Intent intent = new Intent(AgentHome.this, DonarDetail.class);
        intent.putExtra("food", .get(position));
        startActivity(intent);


    */


}

