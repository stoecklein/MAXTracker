package com.example.matthew.maxtracker;

public class Stop {
    Stop(int idIn, String nameIn, String snippetIn, double latIn, double lonIn, int southFreqIn, int northFreqIn, boolean extendedIn){
        id = idIn;  // Stop ID. Numbered along route, N-S, E-W. Used for iterating through stops
        stopName = nameIn;
        snippet = snippetIn;    // Description of stop. Ex "River Market"
        lat = latIn;
        lon = lonIn;
        southFrequency = southFreqIn;   // First minute of the hour that the bus some to the stop. Ex "7"
        northFrequency = northFreqIn;   // First minute of the hour that the bus some to the stop. Ex "7"
        extended = extendedIn;  // Boolean, True if extended
    }

    int id;
    String stopName;
    String snippet;
    double lat;
    double lon;
    int southFrequency;
    int northFrequency;
    boolean extended;

    int getId(){return id;}
    String getName(){return stopName;}
    String getSnippet(){return snippet;}
    double getLat(){return lat;}
    double getLon(){return lon;}
    int getNorthFrequency(){return northFrequency;}
    int getSouthFrequency(){return southFrequency;}
    boolean isExtended(){return extended;}

}