package com.example.matt.calendar;

/**
 * Created by Matt on 2/5/2016.
 */
public class Month {

    public enum days {
        SUNDAY, MONDAY, TUESDAY, WEDNESDAY,
        THURSDAY, FRIDAY, SATURDAY
    }

    public enum months {
        January, February, March, April,
        May, June, July, August,
        September, October, November, December
    }


    public months month;           //jan-dec, 0-11
    public int year;            //year for the current month
    public int numberOfDays;    //number of days in a month
    public int selectedDate;    //actual calendar date
    public days startDayOfWeek;  //sunday - saturday, 0-6

    Month(){
    }

    Month(int year, months month, int numDays, days startDayOfWeek){
        this.year = year;
        this.month = month;
        this.numberOfDays = numDays;
        this.startDayOfWeek = startDayOfWeek;
    }

    void setNumberOfDays(int numDays){
        this.numberOfDays = numDays;
    }

    void setMonth(months month){
        this.month = month;
    }
    void setYear(int year){
        this.year = year;
    }
    void setSelectedDate(int selectedDate){
        this.selectedDate = selectedDate;
    }
    void setStartDayOfWeek(days startDayOfWeek){
        this.startDayOfWeek = startDayOfWeek;
    }

}
