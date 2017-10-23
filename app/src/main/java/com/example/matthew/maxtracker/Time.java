package com.example.matthew.maxtracker;

import java.time.LocalDateTime;
import java.util.Calendar;

/**
 * Created by matthew on 10/23/17.
 */

public class Time {

    Time(int startIn, int endIn){
        startTime = startIn;
        endTime = endIn;
    }

    int startTime;
    int endTime;

    boolean isBusOper(){
        Calendar calendar = Calendar.getInstance();
        int currentHours = LocalDateTime.now().getHour();
        int currentMinute = LocalDateTime.now().getMinute();
        //int seconds = calendar.get(Calendar.SECOND);
        if( (currentHours < startTime) && (currentHours > endTime )){
            return false;
        }
        else {
            return true;
        }
    }

    void updateTimeRemaining(){

    }

}
