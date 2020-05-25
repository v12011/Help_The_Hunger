package com.e.helpthehunger;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import java.util.ArrayList;
import java.util.jar.Attributes;

public class Adapter extends FirebaseRecyclerAdapter<Donar, Adapter.holder>{

    private Listner mlistner;
    private Context mcontext;


    public Adapter(Context context,@NonNull FirebaseRecyclerOptions<Donar> options) {
        super(options);
        mcontext = context;
    }

    @Override
    protected void onBindViewHolder(@NonNull holder holder, int i, @NonNull final Donar donar) {

        holder.name.setText(donar.getName());
        holder.type.setText(donar.getType());
        holder.person.setText(donar.getPerson());
        holder.state.setText(donar.getState());
        holder.phone.setText(donar.getPhone());

        holder.detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mcontext,DonarDetail.class);
                intent.putExtra("donar_name",donar);

            }
        });

    }

    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recy,parent,false);

        return new holder(view, mlistner );
    }


    class holder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView name, type, person, state, phone;
        Listner listner;
        LinearLayout detail;

            public holder (@NonNull View itemView, Listner listner) {
                super(itemView);

                 name =  itemView.findViewById(R.id.dname);
                 type = itemView.findViewById(R.id.dtype);
                 person = itemView.findViewById(R.id.dquantity);
                 state = itemView.findViewById(R.id.dstate);
                 phone = itemView.findViewById(R.id.phone1);
                 detail = itemView.findViewById(R.id.det);
                 this.listner = listner;

                 itemView.setOnClickListener(this);

            }

        @Override
        public void onClick(View v) {
            listner.click(getAdapterPosition());

        }
    }


        public interface  Listner{

        void click(int position);

        }
}





