package com.example.matt.calendar;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

public class DayActivity extends AppCompatActivity {

    public int year;
    public int month;
    public int day;

    ActivityFragment newAct;
    int contentId;

    Events events = Events.getInstance();
    LinearLayout screen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day);
        screen = (LinearLayout)findViewById(R.id.activity_day);

        Bundle values = getIntent().getExtras();

        year = values.getInt("year");
        month = values.getInt("month");
        day = values.getInt("day");
        String date = new String();
        date = Integer.toString(year) + Integer.toString(month) + Integer.toString(day);

        ////////////////////////


        if(events.getEvents(date)!=null) {
            Iterator<Event> iter = events.getEvents(date).iterator();
            while (iter.hasNext()) {
                Event item = iter.next();
                newAct = new ActivityFragment();
                newAct.setDescription("Go home");
                newAct.setDuration("4M");
                newAct.setTime("4am");
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.add(screen.getId(),newAct).commit();
            }
        }
        else
        {
            events.setEvent(date,new Event("time","Description","duration"));
        }

        /*Button bTest = (Button)findViewById(R.id.test_button);
        bTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"y:" + year + "/m:" + (month+1) + "/d:" + day, Toast.LENGTH_SHORT).show();

            }
        });*/



    }
}
