package com.example.matthew.maxtracker;


import java.util.ArrayList;
import java.util.List;

public class Stop {
    Stop(int idIn, String nameIn, String snippetIn, double latIn, double lonIn, int southFreqIn, int northFreqIn, boolean extendedIn){
        id = idIn;
        stopName = nameIn;
        snippet = snippetIn;
        lat = latIn;
        lon = lonIn;
        southFreqIn = southFrequency;
        northFreqIn = northFrequency;
        extendedIn = extended;
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

}