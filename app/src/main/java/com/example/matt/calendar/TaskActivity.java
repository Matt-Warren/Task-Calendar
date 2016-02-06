package com.example.matt.calendar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TaskActivity extends AppCompatActivity {

    public int year;
    public int month;
    public int day;

    public int startHour;
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

        Bundle values = getIntent().getExtras();

        year = values.getInt("year");
        month = values.getInt("month");
        day = values.getInt("day");


        test        = (EditText)findViewById(R.id.task_test);

        taskTitle   = (EditText)findViewById(R.id.task_title);
        taskDesc    = (EditText)findViewById(R.id.task_description);
        taskDur     = (EditText)findViewById(R.id.task_duration);
        taskStart   = (EditText)findViewById(R.id.task_start_time);
        taskYear    = (EditText)findViewById(R.id.task_year);
        taskMonth   = (EditText)findViewById(R.id.task_month);
        taskDay     = (EditText)findViewById(R.id.task_day);

        bAddTask    = (Button)findViewById(R.id.add_task);

        taskYear.setText(Integer.toString(year));
        taskMonth.setText(Integer.toString(month));
        taskDay.setText(Integer.toString(day));

        bAddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                year = Integer.parseInt(taskYear.getText().toString());
                month = Integer.parseInt(taskMonth.getText().toString());
                day = Integer.parseInt(taskDay.getText().toString());
                title = taskTitle.getText().toString();
                description = taskDesc.getText().toString();
                startHour = Integer.parseInt(taskStart.getText().toString());
                duration = Integer.parseInt(taskDur.getText().toString());

                test.setText("Added:\n\tYYYY/MM/DD: " + year + "/" + month + "/" + day + "\n\tStarting Time: " + startHour + "\n\tDuration: " + duration + "\n\tTitle: " + title + "\n\tDescription: " + description);
            }
        });

    }
}
