package com.example.brendanmcantosh.androidtickets;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

public class Tickets extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    private RecyclerView TicketViewer;
    private RecyclerView.LayoutManager TicketLayoutManage;
    private List<String> list;
    private RecyclerAdapter Adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tickets);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        // Initialize Submit Maintenance Button
        Button SubmitMaintenanceBtn = (Button)findViewById(R.id.MaintenanceSubmit);

        // Initialize Vew Ticket Button
        Button ViewFullTicket = (Button)findViewById(R.id.ViewTicketButton);

        //Initializing the recycler view and giving it a layout
        TicketViewer = findViewById(R.id.TicketViewer);
        TicketLayoutManage = new LinearLayoutManager(this);
        TicketViewer.setLayoutManager(TicketLayoutManage);
        list = Arrays.asList(getResources().getStringArray(R.array.TicketIDs));
        Adapter = new RecyclerAdapter(list);
        TicketViewer.setHasFixedSize(true);
        TicketViewer.setAdapter(Adapter);





    }

}
