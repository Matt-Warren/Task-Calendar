package com.example.matt.calendar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;

public class TaskActivity extends AppCompatActivity {

    public int year;
    public int month;
    public int day;

    public int startHour;
    public int duration;

    public String title;
    public String description;

    EditText taskTitle;
    EditText taskDesc;
    EditText taskDur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        Bundle values = getIntent().getExtras();

        year = values.getInt("year");
        month = values.getInt("month");
        day = values.getInt("day");

        taskTitle   = (EditText)findViewById(R.id.task_title);
        taskDesc    = (EditText)findViewById(R.id.task_description);
        taskDur     = (EditText)findViewById(R.id.task_duration);


    }
}
