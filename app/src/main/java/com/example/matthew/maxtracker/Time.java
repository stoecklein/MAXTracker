package com.example.matthew.maxtracker;

import android.content.Context;
import android.widget.TextView;

import java.time.LocalDateTime;
import java.util.Calendar;

/**
 * Created by matthew on 10/23/17.
 */

public class Time {

    Time(int startIn, int endIn, Context mContext){
        try {
            this.mContext = mContext;
            assert mContext != null;
        }
        catch (AssertionError e) {
            System.exit(0);
        }

        startTime = startIn;
        endTime = endIn;
    }

    Context mContext;
    int startTime;
    int endTime;


    // Returns current hour
    int getCurrentHour(){
        Calendar calendar = Calendar.getInstance();
        int currentHour = LocalDateTime.now().getHour();
        return currentHour;
    }

    // Returns current Minute
    int getCurrentMinunte(){
        Calendar calendar = Calendar.getInstance();
        int currentMinute = LocalDateTime.now().getMinute();
        return currentMinute;
    }


    boolean isBusOper(){
        if( (getCurrentHour() < startTime) && (getCurrentHour() > endTime )){
            return false;
        }
        else {
            return true;
        }
    }

    void TimeRemaining(TextView timeRemaining, TextView directionText, int direction, String[] endStops, Stop ClosestStop){

        int currentMinute;
        int frequencyIndex;
        int northFrequency = ClosestStop.getNorthFrequency();
        int southFrequency = ClosestStop.getSouthFrequency();

        if (ClosestStop.isExtended() == true){
            frequencyIndex = 30;
        }
        else{
            frequencyIndex =  15;
        }

        directionText.setText(endStops[direction]);

        currentMinute = getCurrentMinunte() % frequencyIndex;

        if (direction == 0) {


            if (currentMinute > northFrequency) {
                northFrequency += frequencyIndex;
            }

            if ((getCurrentHour() == 0) && ((getCurrentMinunte() + 15) > 60) && (currentMinute > ClosestStop.getNorthFrequency())) {
                timeRemaining.setText(Math.abs(currentMinute - northFrequency) + " ");//LAST
            } else {
                timeRemaining.setText(Math.abs(currentMinute - northFrequency) + " ");
            }
        }

        else {
            if (currentMinute > southFrequency) {
                southFrequency += frequencyIndex;
            }

            if ((getCurrentHour() == 0) && ((getCurrentHour() + 15) > 60) && (currentMinute > ClosestStop.getSouthFrequency())) {
                timeRemaining.setText(Math.abs(currentMinute - southFrequency) + " ");//LAST
            } else {
                timeRemaining.setText(Math.abs(currentMinute - southFrequency) + " ");
            }
        }
    }

}
