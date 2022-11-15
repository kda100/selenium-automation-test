package com.clocksoftware.base;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestUtilities extends BaseTest{

    protected Date today = new Date();

    protected Date getTomorrowsDate() {
        return new Date(today.getTime() + (1000*60*60*24));
    }

    protected String getThisMonth() {
        return convertDateToFormat(today, "MM");
    }

    protected String getNextYear() {
        return String.valueOf(Integer.parseInt(convertDateToFormat(today, "yyyy")) + 1);
    }


    protected String convertDateToFormat(Date date, String format) {
        return new SimpleDateFormat(format).format(date);
    }

//    protected void sleep(long millis) {
//        try {
//            Thread.sleep(millis);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
