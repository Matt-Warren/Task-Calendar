/*
 * File: TaskActivity.java
 * Assignment: Mobile Application Design Assignment 1
 * Authors: Matt Warren & Steven Johnston
 * Date: 2016/02/07
 * Description: This file is for the activity that allows the user to add tasks to the calendar.
 */

package com.example.matt.calendar;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

public class TaskActivity extends AppCompatActivity {

    //passed in values from the bundle
    public int tYear;
    public int tMonth;
    public int tDay;

    //variables for the fields in this activity
    public int startHour;
    public int startMin;
    public boolean isAM;
    public int duration;
    public String title;
    public String description;


    EditText test;

    EditText taskTitle;
    EditText taskDesc;
    EditText taskDur;
    EditText taskStart;
    EditText taskYear;
    EditText taskMonth;
    EditText taskDay;

    Button bAddTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        //get the values from previous activity
        Bundle values = getIntent().getExtras();
        tYear = values.getInt("year");
        tMonth = (values.getInt("month"));
        tDay = values.getInt("day");

        test        = (EditText)findViewById(R.id.task_test);

        taskTitle   = (EditText)findViewById(R.id.task_title);
        taskDesc    = (EditText)findViewById(R.id.task_description);
        taskDur     = (EditText)findViewById(R.id.task_duration);
        taskStart   = (EditText)findViewById(R.id.task_start_time);
        taskYear    = (EditText)findViewById(R.id.task_year);
        taskMonth   = (EditText)findViewById(R.id.task_month);
        taskDay     = (EditText)findViewById(R.id.task_day);

        bAddTask    = (Button)findViewById(R.id.add_task);

        taskYear.setText(Integer.toString(tYear));
        taskMonth.setText(Integer.toString(tMonth));
        taskDay.setText(Integer.toString(tDay));

        //on click listener for all of the date fields (year, month day)
        View.OnClickListener ymdListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar mCurrentTime = Calendar.getInstance();
                //get the current date
                int mYear = mCurrentTime.get(Calendar.YEAR);
                int mMonth = mCurrentTime.get(Calendar.MONTH);
                int mDay = mCurrentTime.get(Calendar.DAY_OF_MONTH);
                //create a DatePicker
                DatePickerDialog mDatePicker;
                //add the listener for OnDateSet
                mDatePicker = new DatePickerDialog(TaskActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        //set the text of the date fields to what was set
                        taskYear.setText(Integer.toString(year));
                        taskMonth.setText(Integer.toString(monthOfYear));
                        taskDay.setText(Integer.toString(dayOfMonth));
                        tYear = year;
                        tMonth = monthOfYear;
                        tDay = dayOfMonth;
                    }
                }, mYear, mMonth, mDay);
                mDatePicker.setTitle("Select Date");
                mDatePicker.show();
            }
        };
        taskYear.setOnClickListener(ymdListener);
        taskMonth.setOnClickListener(ymdListener);
        taskDay.setOnClickListener(ymdListener);

        //on click listener for the time field (starting time)
        taskStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar mCurrentTime = Calendar.getInstance();
                //get the current time
                int hour = mCurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mCurrentTime.get(Calendar.MINUTE);
                //create a TimePicker
                TimePickerDialog mTimePicker;
                //add the listener for OnTimeSet
                mTimePicker = new TimePickerDialog(TaskActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        String minutes;
                        //convert to 12h time, not 24
                        if (selectedHour > 12) {
                            selectedHour -= 12;
                            isAM = false;
                        } else if (selectedHour == 12) {
                            isAM = false;
                        } else if (selectedHour == 0) {
                            selectedHour = 12;
                            isAM = true;
                        } else {
                            isAM = true;
                        }
                        startHour = selectedHour;
                        startMin = selectedMinute;
                        //change the text to be the time that was set
                        taskStart.setText(selectedHour + ":" + ((selectedMinute < 10) ? "0" + selectedMinute : selectedMinute) + ((isAM) ? " AM" : " PM"));
                    }
                }, hour, minute, false);//Yes 24 hour time
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();
            }
        });

        //On click listener for the button
        bAddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get all of the data from the fields and store them in variables
                tYear = Integer.parseInt(((taskYear.getText().toString().equals("")) ? "0" : taskYear.getText().toString()));
                tMonth = Integer.parseInt(((taskMonth.getText().toString().equals("")) ? "0" : taskMonth.getText().toString()));
                tDay = Integer.parseInt(((taskDay.getText().toString().equals("")) ? "0" : taskDay.getText().toString()));
                title = taskTitle.getText().toString();
                description = taskDesc.getText().toString();
                duration = Integer.parseInt(((taskDur.getText().toString().equals(""))? "0" : taskDur.getText().toString()));

                //create a new event
                Events events = Events.getInstance();
                Event event = new Event(Integer.toString(startHour) + ":" + Integer.toString(startMin),description,Integer.toString(duration));
                String date = Integer.toString(tYear) + Integer.toString(tMonth) + Integer.toString(tDay);
                events.setEvent(date,event); //add the event

                test.setText("Added:\n\tYYYY/MM/DD: " + tYear + "/" + tMonth + "/" + tDay + "\n\tStarting Time: " + startHour + ":" + ((startMin < 10) ? "0"+startMin : startMin) + ((isAM) ? " AM" : " PM") + "\n\tDuration: " + duration + "\n\tTitle: " + title + "\n\tDescription: " + description);
            }
        });

    }
}
