package com.example.brendanmcantosh.androidtickets;
/*
This file is for the layout of the recycler view that will be holding the tickets
*/
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

public class RecyclerAdapterv2 extends RecyclerView.Adapter<RecyclerAdapterv2.MyViewHolder>
{

    private List<String> list;

    public RecyclerAdapterv2 (List<String> list)
    {
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        RelativeLayout textview = (RelativeLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.relative_layout,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(textview);


        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int i) {
        holder.TicketID.setText(list.get(i));

    }

    @Override
    public int getItemCount() {


        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder
    {

        TextView TicketID;
        public MyViewHolder(TextView itemView) {
            super(itemView);
            TicketID = itemView;
        }
    }
}
