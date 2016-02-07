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

    //Hold the date. used to get all events for a day
    public int year;
    public int month;
    public int day;

    //used to create additional activities
    ActivityFragment newAct;

    //Gets the singleton instance. This hold all event. Our database as of now.
    Events events = Events.getInstance();
    //Used to hold the most outer layout that we created.
    LinearLayout screen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day);
        //get reference to outer layout
        screen = (LinearLayout)findViewById(R.id.activity_day);
        //Get values sent from last instance
        Bundle values = getIntent().getExtras();

        //Set the date from the values from last instance
        year = values.getInt("year");
        month = values.getInt("month");
        day = values.getInt("day");
        //Create date as a single string
        String date;
        date = Integer.toString(year) + Integer.toString(month) + Integer.toString(day);

        //Check if any events exist for the date
        if(events.getEvents(date)!=null) {
            //Create iterator for the list of events for given date
            Iterator<Event> iter = events.getEvents(date).iterator();
            //Loop interator
            while (iter.hasNext()) {
                //Get next even from list
                Event item = iter.next();
                //Create a new activity fragment
                newAct = new ActivityFragment();
                //Set the visible values of the fragment
                newAct.setDescription(item.getDescription());
                newAct.setDuration(item.getDuration());
                newAct.setTime(item.getTime());
                //State framgment trasaction
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                //Add new fragment to the screen
                ft.add(screen.getId(),newAct).commit();
            }
        }

    }
    //Required to use fragment
    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
