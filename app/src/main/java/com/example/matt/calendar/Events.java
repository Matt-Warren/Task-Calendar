package com.example.matt.calendar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Steven Johnston on 2/5/2016.
 */
//Singleton class that hold all the events for all dates
public class Events {

    //Map of dates to a list of events
    private Map<String, ArrayList<Event>> events = new HashMap<String,ArrayList<Event>>();

    //Single instance of Events
    private static Events ourInstance = new Events();

    //Getter for or single instance
    public static Events getInstance() {
        return ourInstance;
    }

    //Gets the list of events for the given date
    //Param:
    // String Key: The key in the map.
    public ArrayList<Event> getEvents(String key)
    {
        //Check if list exist
        if(events.containsKey(key)) {
            //return list
            return events.get(key);
        }
        else
        {
            return null;
        }
    }

    //Adds an event to given date. If date has no events, a list of events will be added to the date
    //Param:
    //  String Key: The key for the map
    //  Event event: The event to add to the list at key
    public void setEvent(String key, Event event)
    {
        //Check if list exist
        if(!events.containsKey(key)) {
            //Create the list
            events.put(key, new ArrayList<Event>());
        }
        //Add event to list
        events.get(key).add(event);
    }
}


