package com.javarush.task.task40.task4007;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/* 
Работа с датами
*/

public class Solution {
    public static void main(String[] args) {
        printDate("21.4.2014 15:56:45");
        System.out.println();
        printDate("18.6.2017");
        System.out.println();
        printDate("17:33:40");
    }

    public static void printDate(String date) {
        //напишите тут ваш код
        Calendar calendar = Calendar.getInstance();
        if (date.length() > 10) {
            SimpleDateFormat dateTimeFormat = new SimpleDateFormat("dd.M.yyyy HH:mm:ss");
            try {
                calendar.setTime(dateTimeFormat.parse(date));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
            System.out.println("День: " + calendar.get(Calendar.DAY_OF_MONTH));
            System.out.println("День недели: " + (dayOfWeek == 0 ? 7 : dayOfWeek));
            System.out.println("День месяца: " + calendar.get(Calendar.DAY_OF_MONTH));
            System.out.println("День года: " + calendar.get(Calendar.DAY_OF_YEAR));
            System.out.println("Неделя месяца: " + calendar.get(Calendar.WEEK_OF_MONTH));
            System.out.println("Неделя года: " + calendar.get(Calendar.WEEK_OF_YEAR));
            System.out.println("Месяц: " + (calendar.get(Calendar.MONTH) + 1));
            System.out.println("Год: " + calendar.get(Calendar.YEAR));
            System.out.println("AM или PM: " + (calendar.get(Calendar.AM_PM) == 0 ? "AM" : "PM"));
            System.out.println("Часы: " + calendar.get(Calendar.HOUR));
            System.out.println("Часы дня: " + calendar.get(Calendar.HOUR_OF_DAY));
            System.out.println("Минуты: " + calendar.get(Calendar.MINUTE));
            System.out.println("Секунды: " + calendar.get(Calendar.SECOND));

        }
        if (date.length() < 11 && date.contains(".")) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.M.yyyy");
            try {
                calendar.setTime(dateFormat.parse(date));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
            System.out.println("День: " + calendar.get(Calendar.DAY_OF_MONTH));
            System.out.println("День недели: " + (dayOfWeek == 0 ? 7 : dayOfWeek));
            System.out.println("День месяца: " + calendar.get(Calendar.DAY_OF_MONTH));
            System.out.println("День года: " + calendar.get(Calendar.DAY_OF_YEAR));
            System.out.println("Неделя месяца: " + calendar.get(Calendar.WEEK_OF_MONTH));
            System.out.println("Неделя года: " + calendar.get(Calendar.WEEK_OF_YEAR));
            System.out.println("Месяц: " + (calendar.get(Calendar.MONTH) + 1));
            System.out.println("Год: " + calendar.get(Calendar.YEAR));
        }
        if (date.length() < 11 && date.contains(":")) {
            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
            try {
                calendar.setTime(timeFormat.parse(date));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            System.out.println("AM или PM: " + (calendar.get(Calendar.AM_PM) == 0 ? "AM" : "PM"));
            System.out.println("Часы: " + calendar.get(Calendar.HOUR));
            System.out.println("Часы дня: " + calendar.get(Calendar.HOUR_OF_DAY));
            System.out.println("Минуты: " + calendar.get(Calendar.MINUTE));
            System.out.println("Секунды: " + calendar.get(Calendar.SECOND));
        }

    }
}
