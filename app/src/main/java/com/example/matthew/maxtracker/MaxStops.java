package com.example.matthew.maxtracker;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by matthew on 10/16/17.
 */

public class MaxStops {
    MaxStops(){
        fillList();
    }

    List<Stop> stopList = new ArrayList<Stop>();

    void fillList(){
        stopList.add(new Stop("On Grand at 3rd", "River Market", 39.110462, -94.580374, 7, false));
        stopList.add(new Stop("On Grand at 5th", "City Market", 39.108897, -94.580481, 7, false));
        stopList.add(new Stop("On Grand at 9th", "Courthouse", 39.103494, -94.580707, 7, false));
        stopList.add(new Stop("On Grand at 11th", "Financial District", 39.101119, -94.580826, 7, false));
        stopList.add(new Stop("On Grand at 12th", "Arena", 39.099873, -94.580918, 7, false));
        stopList.add(new Stop("On Grand at 16th", "Crossroads Arts District", 39.094459, -94.581199, 7, false));
        stopList.add(new Stop("On Grand at 19th", "Crossroads Arts District", 39.090433, -94.581396, 7, false));
        stopList.add(new Stop("On Grand at 22nd", "Washington Sq. Park", 39.086061, -94.581599, 7, false));
        stopList.add(new Stop("On Grand at Pershing", "Crown Center", 39.083593, -94.581720, 7, false));
        stopList.add(new Stop("On Main at 29th", "Liberty Memorial", 39.074763, -94.585088, 7, false));
        stopList.add(new Stop("On Main at 31st", "Union Hill", 39.070939, -94.585297, 7, false));
        stopList.add(new Stop("On Main at Linwood", "On Main at Linwood", 39.068265, -94.585429, 7, false));
        stopList.add(new Stop("On Main at Armour", "On Main at Armour", 39.063798, -94.585644, 7, false));
        stopList.add(new Stop("On Main at 39th", "39th", 39.056568, -94.586100, 7, false));
        stopList.add(new Stop("On Main at 43rd", "43rd", 39.049334, -94.586518, 7, false));
        stopList.add(new Stop("On Main at 45th", "Art Museums", 39.046319, -94.586688, 7, false));
        stopList.add(new Stop("On Main at 47th", "Country Club Plaza", 39.041274, -94.588069, 7, false));
        stopList.add(new Stop("On Main at 49th", "Plaza Library", 39.038987, -94.587116, 7, false));
        stopList.add(new Stop("On Brookside at 51st", "UMKC", 39.034369, -94.584249, 7, true));
        stopList.add(new Stop("On Brookside at 55th", "Brookside", 39.027420, -94.584853, 7, true));
        stopList.add(new Stop("On Brookside at 59th", "Brookside", 39.020285, -94.588330, 7, true));
        stopList.add(new Stop("On Brookside at 63rd", "Brookside", 39.013916, -94.591547, 7, true));
        stopList.add(new Stop("On Wornall at Gregory", "Gregory", 38.999689, -94.593838, 7, true));
        stopList.add(new Stop("...", "Waldo", 38.993336, -94.593783, 7, true));

    }


    void addMapMarkers(GoogleMap map){

        Iterator<Stop> itr = stopList.iterator();
        while (itr.hasNext()){

            Stop itrObject = itr.next();

            map.addMarker(new MarkerOptions()
                .position(new LatLng(itrObject.getLat(), itrObject.getLon()))
                .title(itrObject.getName())
                .snippet(itrObject.getSnippet()));
        }
    }
}