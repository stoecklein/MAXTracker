package com.example.matthew.maxtracker;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.widget.TextView;

import java.time.LocalDateTime;
import java.util.Calendar;

/**
 * Created by matthew on 10/23/17.
 */

public class Time {

    Time(int startIn, int endIn, Context mContext){
        this.mContext = mContext;
        startTime = startIn;
        endTime = endIn;
    }

    Context mContext;
    int startTime;
    int endTime;

    int getCurrentHour(){
        Calendar calendar = Calendar.getInstance();
        int currentHour = LocalDateTime.now().getHour();
        return currentHour;
    }

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

    void TimeRemaining(TextView Ntime, TextView Stime, Stop ClosestStop){

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

        currentMinute = getCurrentMinunte() % frequencyIndex;

        if(currentMinute > northFrequency) {
                northFrequency += frequencyIndex;
        }

        if((getCurrentHour() == 0) && ((getCurrentMinunte() + 15) > 60) && (currentMinute > ClosestStop.getNorthFrequency())){
            Stime.setText(Math.abs(currentMinute - northFrequency) + " Minutes Last");
        }
        else {
            Ntime.setText(Math.abs(currentMinute - northFrequency) + " Minutes");
        }

        if(currentMinute > southFrequency) {
                southFrequency += frequencyIndex;
        }

        if((getCurrentHour() == 0) && ((getCurrentHour() + 15) > 60) && (currentMinute > ClosestStop.getSouthFrequency())){
            Stime.setText(Math.abs(currentMinute - southFrequency) + " Minutes Last");
        }
        else {
            Stime.setText(Math.abs(currentMinute - southFrequency) + " Minutes");
        }
    }

}
