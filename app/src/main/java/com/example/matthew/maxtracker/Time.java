package com.example.matthew.maxtracker;

import java.time.LocalDateTime;
import java.util.Calendar;

/**
 * Created by matthew on 10/23/17.
 */

public class Time {
    boolean isBusOper(int hourStart, int hourEnd){
        Calendar calendar = Calendar.getInstance();
        int currentHours = LocalDateTime.now().getHour();
        int currentMinute = LocalDateTime.now().getMinute();
        //int seconds = calendar.get(Calendar.SECOND);
        if( (currentHours < hourStart) && (currentHours > hourEnd )){
            return false;
        }
        else {
            return true;
        }
    }

    void updateTimeRemaining(){

    }

}
