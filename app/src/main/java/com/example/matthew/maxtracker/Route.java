package com.example.matthew.maxtracker;

/**
 * Created by matthew on 10/23/17.
 */

// Route class holds lat and lon for each stop on the route
// to populate the list that draws the route line

public class Route {
    Route(double latIn, double lonIn){
        lat = latIn;
        lon = lonIn;
    }
    double lat;
    double lon;
}
