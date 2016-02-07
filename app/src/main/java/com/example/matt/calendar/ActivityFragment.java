/*
 * File: ActivityFragment.java
 * Assignment: Mobile Application Design Assignment 1
 * Authors: Matt Warren & Steven Johnston
 * Date: 2016/02/07
 * Description: This file is for the fragments that outline the individual tasks.
 */

package com.example.matt.calendar;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class ActivityFragment extends Fragment {

    //Text Views for Time, description and duration
    //Duration will come later
    TextView timeView, descriptionView, durationView;
    //Strings for each text view
    private String time ="";
    private String description="";
    private String duration="";

    public ActivityFragment() {
    }

    //Creates a newInstance of this fragment
    public static ActivityFragment newInstance() {
        ActivityFragment fragment = new ActivityFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    //Called after the onCreate Method so that we can set the data in the textviews
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_activity, container, false);
        //Get references for each text view
        timeView = (TextView) view.findViewById(R.id.time);
        descriptionView = (TextView) view.findViewById(R.id.description);
        durationView = (TextView) view.findViewById(R.id.duration);
        //Fill the text views with the values of this class
        fillData();
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    //Setter for the time value
    public void setTime(String time) {
        this.time = time;
    }

    //Getter for the description value
    public String getDescription() {
        return description;
    }

    //Setter of the Description value
    public void setDescription(String description) {
        this.description = description;
    }

    //Getter for the duration value
    public String getDuration() {
        return duration;
    }

    //Setter of the duration value
    public void setDuration(String duration) {
        this.duration = duration;
    }

    //Getter for the time value
    public String getTime() {
        return time;
    }

    //Fills the text views with the corresponding data in the class
    private void fillData()
    {
        timeView.setText(time);
        descriptionView.setText(description);
        durationView.setText(duration);
    }


    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
