/*
 * File: Event.java
 * Assignment: Mobile Application Design Assignment 1
 * Authors: Matt Warren & Steven Johnston
 * Date: 2016/02/07
 * Description: This file is for
 */

package com.example.matt.calendar;

//Used to store information about a single event
public class Event {
    private String time;
    private String description;
    private String duration;

    //Create event and set the tine description and duration
    public Event(String time, String description , String duration) {
        this.time = time;
        this.description = description;
        this.duration = duration;
    }

    //Getter for the duration value
    public String getDuration() {
        return duration;
    }

    //Setter for the duration value
    public void setDuration(String duration) {
        this.duration = duration;
    }

    //Getter for the time value
    public String getTime() {
        return time;
    }

    //Setter for the time value
    public void setTime(String time) {
        this.time = time;
    }

    //Getter for the description Value
    public String getDescription() {
        return description;
    }

    //Setter for the desctription
    public void setDescription(String description) {
        this.description = description;
    }
}
