/*
 * File: DayActivity.java
 * Assignment: Mobile Application Design Assignment 1
 * Authors: Matt Warren & Steven Johnston
 * Date: 2016/02/07
 * Description: This file is to show a daily view of the tasks that a user has created.
 */

package com.example.matt.calendar;

import android.net.Uri;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import java.util.Iterator;

public class DayActivity extends AppCompatActivity implements ActivityFragment.OnFragmentInteractionListener {

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
        String date;
        date = Integer.toString(year) + Integer.toString(month) + Integer.toString(day);

        ////////////////////////
        contentId = screen.getId();

        if(events.getEvents(date)!=null) {
            Iterator<Event> iter = events.getEvents(date).iterator();
            while (iter.hasNext()) {
                Event item = iter.next();
                newAct = new ActivityFragment();
                newAct.setDescription(item.getDescription());
                newAct.setDuration(item.getDuration());
                newAct.setTime(item.getTime());
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.add(screen.getId(),newAct).commit();
            }
        }
        else
        {
            //events.setEvent(date,new Event("T5","DeDang","DurNo"));
        }



        /*Button bTest = (Button)findViewById(R.id.test_button);
        bTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"y:" + year + "/m:" + (month+1) + "/d:" + day, Toast.LENGTH_SHORT).show();

            }
        });*/

    }
    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
