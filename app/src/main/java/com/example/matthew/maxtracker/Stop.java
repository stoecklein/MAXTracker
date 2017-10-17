package com.example.matthew.maxtracker;

public class Stop {
    Stop(String nameIn, String snippetIn, double latIn, double lonIn, int freqIn, boolean extendIn){
        stopName = nameIn;
        snippet = snippetIn;
        lat = latIn;
        lon = lonIn;
        timeFreq = freqIn;
        extended = extendIn;
    }

    String stopName;
    String snippet;
    double lat;
    double lon;
    int timeFreq;
    boolean extended;

    String getName(){return stopName;}
    String getSnippet(){return snippet;}
    double getLat(){return lat;}
    double getLon(){return lon;}
    int getTimeFreq(){return timeFreq;}
    Boolean getExtended(){return extended;}
}