package com.example.matt.calendar;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Toast;

public class MonthCalendar extends AppCompatActivity {

    CalendarView calendar;
    Button bViewDate;
    Button bViewTask;

    public int year;
    public int month;
    public int day;
    public long date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_month_calendar);
        initializeCalendar();
        bViewDate = (Button) findViewById(R.id.view_date);
        bViewDate.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {   //go to the date view part here
                Toast.makeText(getApplicationContext(),"Going to day sending: " + day + "/" + (month+1) + "/" + year, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), DayActivity.class);
                Bundle bExtras = new Bundle();

                bExtras.putInt("year", year);
                bExtras.putInt("month", month);
                bExtras.putInt("day", day);

                intent.putExtras(bExtras);
                startActivity(intent);
            }
        });
        bViewTask = (Button) findViewById(R.id.view_task);
        bViewTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Going to task sending: " + day + "/" + (month+1) + "/" + year, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), TaskActivity.class);
                Bundle bExtras = new Bundle();

                bExtras.putInt("year", year);
                bExtras.putInt("month", month);
                bExtras.putInt("day", day);

                intent.putExtras(bExtras);
                startActivity(intent);
            }
        });

    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public void initializeCalendar(){
        calendar = (CalendarView) findViewById(R.id.calendar);
        calendar.setShowWeekNumber(false);
        calendar.setFirstDayOfWeek(1); //set monday to first day of week
        date = calendar.getDate();
        //sets the listener to be notified upon selected date change.
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
        //show the selected date as a toast
            @Override
            public void onSelectedDayChange(CalendarView view, int newYear, int newMonth, int newDay) {
                //month is 0 - 11
                year = newYear;
                month = newMonth;
                day = newDay;
                Toast.makeText(getApplicationContext(), newDay + "/" + (newMonth+1) + "/" + newYear, Toast.LENGTH_SHORT).show();

            }
        });
    }
}
