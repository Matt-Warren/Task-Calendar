package com.example.matt.calendar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Steven Johnston on 2/5/2016.
 */
public class Events {
    private Map<String, ArrayList<Event>> events = new HashMap<String,ArrayList<Event>>();
    private String date;

    private static Events ourInstance = new Events();

    public Map<String, ArrayList<Event>> getEvents() {
        return events;
    }

    public void setEvents(Map<String, ArrayList<Event>> events) {
        events = events;
    }

    public static Events getInstance() {
        return ourInstance;
    }


    public ArrayList<Event> getEvents(String key)
    {
        if(events.containsKey(key)) {
            return events.get(key);
        }
        else
        {
            return null;
        }
    }

    public void setEvent(String key, Event event)
    {
        if(!events.containsKey(key)) {
            events.put(key, new ArrayList<Event>());
        }
        events.get(key).add(event);
    }

    private Events() {

    }
}


