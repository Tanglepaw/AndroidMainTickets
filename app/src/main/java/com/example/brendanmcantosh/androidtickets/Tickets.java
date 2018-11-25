package com.example.brendanmcantosh.androidtickets;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.sql.SQLData;
import java.util.ArrayList;
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
    // Arrays that hold the ticket data
    public static ArrayList<String> mTicketID = new ArrayList<>();
    public static ArrayList<String> mWorksite = new ArrayList<>();
    public static ArrayList<String> mPriority = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tickets);

        //mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        // Initialize Vew Ticket Button Will pass ticket ID to View full ticket module
        Button ViewFullTicket = (Button)findViewById(R.id.ViewTicketButton);


        AddTicketInfo();

        initRecyclerView();

    }

    private void initRecyclerView (){
        RecyclerView TicketViewer = findViewById(R.id.TicketViewer);
        RelativeRecyclerAdapter adapter = new RelativeRecyclerAdapter(mTicketID, mWorksite, mPriority);
        TicketViewer.setAdapter(adapter);
        TicketViewer.setLayoutManager(new LinearLayoutManager(this ));

    }

    private void AddTicketInfo (){
        // THIS IS WHERE YOU NEED TO PUT THE GETTER
        String FWid = "11"; // FWid will need to be changed to accept input from login
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute("TicketStart", FWid);

    }

}
