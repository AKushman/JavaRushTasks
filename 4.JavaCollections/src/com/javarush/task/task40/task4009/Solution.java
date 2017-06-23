package com.javarush.task.task40.task4009;

import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.TemporalField;
import java.util.Locale;

/* 
Buon Compleanno!
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(weekDayOfBirthday("30.05.1984", "2015"));
    }

    public static String weekDayOfBirthday(String birthday, String year) {
        //напишите тут ваш код
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.y");
        LocalDate date = LocalDate.parse(birthday, formatter);
        date = date.withYear(Year.parse(year).getValue());
        String dayOfWeek = date.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ITALIAN);
        return dayOfWeek;
    }
}
