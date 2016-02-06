package com.example.matt.calendar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DayActivity extends AppCompatActivity {

    public int year;
    public int month;
    public int day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day);

        Bundle values = getIntent().getExtras();

        year = values.getInt("year");
        month = values.getInt("month");
        day = values.getInt("day");


        Button bTest = (Button)findViewById(R.id.test_button);
        bTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"y:" + year + "/m:" + (month+1) + "/d:" + day, Toast.LENGTH_SHORT).show();

            }
        });
    }
}
