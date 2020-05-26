package com.company;

import java.util.HashMap;
import java.util.Map;

public class Location {

    private final  int  locationID;
    private final String description;
    private final Map<String, Integer> exits;

    public Location(int locationID, String description) {
        this.locationID = locationID;
        this.description = description;
        exits = new HashMap<String, Integer>();
        this.addExit("Q",0);

    }

    public int getLocationID() {
        return locationID;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Integer> getExists() {
        return new HashMap<String, Integer>(exits);
    }

    public void addExit(String direction, int location){
        exits.put(direction,location);

    }
}
