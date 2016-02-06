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

import java.util.Calendar;

public class MonthCalendar extends AppCompatActivity {

    CalendarView calendar;
    Button bViewDate;
    Button bViewTask;

    public int year;
    public int month;
    public int day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_month_calendar);
        year = 0;
        month = 0;
        day = 0;
        initializeCalendar();
        bViewDate = (Button) findViewById(R.id.view_date);
        bViewDate.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {   //go to the date view part here

                Intent intent = new Intent(getApplicationContext(), DayActivity.class);
                Bundle bExtras = new Bundle();
                Calendar calendar = Calendar.getInstance();


                bExtras.putInt("year", ((year==0) ? calendar.get(Calendar.YEAR) : year) );

                bExtras.putInt("month", ((month==0) ? calendar.get(Calendar.MONTH) : month));
                bExtras.putInt("day", ((day==0) ? calendar.get(Calendar.DAY_OF_MONTH) : day));
                Toast.makeText(getApplicationContext(), "Going to date sending: " + ((day == 0) ? calendar.get(Calendar.DAY_OF_MONTH) : day) + "/" + (((month == 0) ? calendar.get(Calendar.MONTH) : month) + 1) + "/" + ((year == 0) ? calendar.get(Calendar.YEAR) : year), Toast.LENGTH_SHORT).show();
                intent.putExtras(bExtras);
                startActivity(intent);
            }
        });
        bViewTask = (Button) findViewById(R.id.view_task);
        bViewTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), TaskActivity.class);
                Bundle bExtras = new Bundle();

                Calendar calendar = Calendar.getInstance();
                bExtras.putInt("year", ((year == 0) ? calendar.get(Calendar.YEAR) : year));
                bExtras.putInt("month", ((month == 0) ? calendar.get(Calendar.MONTH) : month));
                bExtras.putInt("day", ((day == 0) ? calendar.get(Calendar.DAY_OF_MONTH) : day));
                Toast.makeText(getApplicationContext(), "Going to task sending: " + ((day == 0) ? calendar.get(Calendar.DAY_OF_MONTH) : day) + "/" + (((month == 0) ? calendar.get(Calendar.MONTH) : month) + 1) + "/" + ((year == 0) ? calendar.get(Calendar.YEAR) : year), Toast.LENGTH_SHORT).show();
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
