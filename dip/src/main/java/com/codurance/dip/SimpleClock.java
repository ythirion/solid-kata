package com.codurance.dip;

import java.time.MonthDay;

public class SimpleClock implements Clock {
    public MonthDay monthDay(){
        return MonthDay.now();
    }
}