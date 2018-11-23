package com.example.brendanmcantosh.androidtickets;
/*
This file is for the layout of the recycler view that will be holding the tickets
*/
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>
{

    private List<String> list;

    public RecyclerAdapter (List<String> list)
    {
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        TextView textView = (TextView) LayoutInflater.from(parent.getContext()).inflate(R.layout.text_view_layout,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(textView);


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
