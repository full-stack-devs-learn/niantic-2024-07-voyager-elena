package com.niantic.services;

import java.time.Month;

public class DateConverter {

    public static int getMonthNumber(String monthName) {
        return Month.valueOf(monthName.toUpperCase()).getValue();
    }

}
