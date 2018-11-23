package com.example.brendanmcantosh.androidtickets;

import android.nfc.Tag;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class RelativeRecyclerAdapter extends RecyclerView.Adapter<RelativeRecyclerAdapter.ViewHolder> {

    private ArrayList<String> mTicketID = new ArrayList<>();
    private ArrayList<String> mWorksite = new ArrayList<>();
    private ArrayList<String> mPriority = new ArrayList<>();
    private ArrayList<String> mStatus = new ArrayList<>();

    public RelativeRecyclerAdapter(ArrayList<String> TicketIDs, ArrayList<String> Worksites, ArrayList<String> Prioritys, ArrayList<String> Status) {
        mTicketID = TicketIDs;
        mWorksite = Worksites;
        mPriority = Prioritys;
        mStatus = Status;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.relative_layout,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        holder.TicketID.setText(mTicketID.get(i));
        holder.Worksite.setText(mWorksite.get(i));
        holder.Priority.setText(mPriority.get(i));
        holder.Status.setText(mStatus.get(i));

    }

    @Override
    public int getItemCount()
    {
        return mTicketID.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView TicketID;
        TextView Worksite;
        TextView Priority;
        TextView Status;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            TicketID = itemView.findViewById(R.id.rTicketID);
            Worksite = itemView.findViewById(R.id.rWorksite);
            Priority = itemView.findViewById(R.id.rPriority);
            Status = itemView.findViewById(R.id.rStatus);
        }
    }

}
