package com.example.matthew.maxtracker;

import android.content.Context;
import android.graphics.Color;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.Iterator;
import java.util.List;

/**
 * Created by matthew on 10/23/17.
 */

public class BusMap {

    BusMap(Context mContext){
        try {
            this.mContext = mContext;
            assert mContext != null;
        }
        catch (AssertionError e) {
            System.exit(0);
        }
    }

    Context mContext;

    // Pre-condition: The Google map has been initialized
    // Post-condition: The Google map contains a marker for every element in maxStopList
    void addMarkers(GoogleMap map, List<Stop> stopList){

        Iterator<Stop> itr = stopList.iterator();
        while (itr.hasNext()){

            Stop itrObject = itr.next();

            map.addMarker(new MarkerOptions()
                    .position(new LatLng(itrObject.getLat(), itrObject.getLon()))
                    .title(itrObject.getName())
                    .snippet(itrObject.getSnippet())
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.map_marker)));
        }
    }

    // Pre-condition: The Google map has been initialized
    // Post-condition: The Google map contains a line to every object in maxRouteList
    void addRoute(GoogleMap map, List<Route> routeList) {

        PolylineOptions rectOptions = new PolylineOptions()
                .width(10)  //Set width for line width (10)
                .color(Color.rgb(228, 0, 43));   //Set color for route line

        Iterator<Route> itr = routeList.iterator();
        while (itr.hasNext()) {

            Route itrObject = itr.next();

            rectOptions.add(new LatLng(itrObject.lat, itrObject.lon));
        }
        Polyline polyline = map.addPolyline(rectOptions);   // Get back the mutable Polyline
    }

    // Pre-condition: stopList is not empty
    // Post-condition:
    Stop closestStop (List<Stop> stopList, double latIn){

        Iterator<Stop> itr = stopList.iterator();
        Stop itrObject = itr.next();    //Points to northern stop object
        Stop itrObjectNext = itr.next();    //Points to southern stop object

        if(latIn > itrObject.getLat()){
            return itrObject;   //If users lat is north of most northern stop, return first object
        }

        while (itr.hasNext()){

            if (latIn < itrObjectNext.getLat()){    //Move to inspect next stop
                itrObject = itrObjectNext;
                itrObjectNext = itr.next();
            }

            else {  //Current users lat is in between north and south stop objects
                if((Math.abs(itrObjectNext.getLat() - latIn)) > (Math.abs(latIn - itrObject.getLat()))){
                    return itrObject;   //If distance from users lat to north stop is less, return it
                }
                else{
                    return itrObjectNext;//If distance from users lat to south stop is less, return it
                }
            }

        }

        return itrObjectNext;   //If users lat is south of most southern stop, return last object
    }
}