/*
 * File: Event.java
 * Assignment: Mobile Application Design Assignment 1
 * Authors: Matt Warren & Steven Johnston
 * Date: 2016/02/07
 * Description: This file is for
 */

package com.example.matt.calendar;

public class Event {
    private String time;
    private String description;
    private String duration;


    public Event(String time, String description , String duration) {
        this.time = time;
        this.description = description;
        this.duration = duration;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
