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

    //  Returns true if bus is running
    boolean isBusOper(){
        if( (getCurrentHour() < startTime) && (getCurrentHour() > endTime )){
            return false;
        }
        else {
            return true;
        }
    }

    // Pre-condition: A list of Stop objects has been initialized
    // Post-condition: Textview display
    void TimeRemaining(TextView timeRemaining, TextView directionText, TextView lastText, int direction, String[] endStops, Stop ClosestStop){

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

        if (direction == 0)
            timeDirection(timeRemaining, lastText, ClosestStop, currentMinute, frequencyIndex, northFrequency);

        else
            timeDirection(timeRemaining, lastText, ClosestStop, currentMinute, frequencyIndex, southFrequency);
    }

    void timeDirection(TextView timeRemaining, TextView lastText, Stop ClosestStop, int currentMinute, int frequencyIndex, int directionFrequency){

        if (currentMinute > directionFrequency) {
            directionFrequency += frequencyIndex;
        }

        if ((getCurrentHour() == 0) && ((getCurrentMinunte() + 15) > 60) && (currentMinute > ClosestStop.getNorthFrequency())) {
            timeRemaining.setText(Math.abs(currentMinute - directionFrequency) + "");
            lastText.setText("Last");//LAST
        } else {
            timeRemaining.setText(Math.abs(currentMinute - directionFrequency) + "");
        }
    }

}
