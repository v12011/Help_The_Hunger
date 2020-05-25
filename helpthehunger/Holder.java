package com.e.helpthehunger;


import android.content.Context;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Holder extends RecyclerView.ViewHolder {


    View view;
    public Holder(@NonNull View itemView) {
        super(itemView);

        view = itemView;

    }

    public void setView (Context context, String Name, String Person , String Phone, String State, String Type){

        TextView name =  view.findViewById(R.id.dname);
        TextView type = view.findViewById(R.id.dtype);
        TextView person = view.findViewById(R.id.dquantity);
        TextView state = view.findViewById(R.id.dstate);
        TextView phone = view.findViewById(R.id.phone1);

        name.setText(Name);
        type.setText(Type);
        person.setText(Person);
        state.setText(State);
        phone.setText(Phone);





    }
}
