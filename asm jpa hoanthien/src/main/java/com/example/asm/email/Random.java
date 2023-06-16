package com.example.asm.email;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public class Random {
    public static Integer randomInteger(){
        Integer randomNum = ThreadLocalRandom.current().nextInt(10000, 99999 + 1);
        return randomNum;
    }

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int week = calendar.get(Calendar.WEEK_OF_YEAR);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);
        System.out.println(year);
    }
}
