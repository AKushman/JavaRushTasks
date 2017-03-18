package com.javarush.task.task08.task0827;


/* 
Работа с датой
*/

import java.util.Calendar;
import java.util.Date;

public class Solution {
    public static void main(String[] args) {
        System.out.println(isDateOdd("MAY 1 2013"));
    }

    public static boolean isDateOdd(String date) {
        long msPerDay = 24 * 60 * 60 * 1000;
        Date yearStart = new Date(date);
        yearStart.setHours(0);
        yearStart.setMinutes(0);
        yearStart.setSeconds(0);
        yearStart.setDate(1);
        yearStart.setMonth(0);
        Date d = new Date(date);
        return ((d.getTime() - yearStart.getTime()) / msPerDay) % 2 == 0;
    }
}
