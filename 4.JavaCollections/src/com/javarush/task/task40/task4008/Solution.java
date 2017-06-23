package com.javarush.task.task40.task4008;

/*
Работа с Java 8 DateTime API
*/


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.WeekFields;
import java.util.Locale;

public class Solution {
    public static void main(String[] args) {
        printDate("21.4.2014 15:56:45");
        System.out.println();
        printDate("21.4.2014");
        System.out.println();
        printDate("17:33:40");
    }

    public static void printDate(String date) {
        if (date.length() > 10) {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("d.M.y");
            LocalDate localDate = LocalDate.parse(date.split(" ")[0], dateFormatter);
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("H:m:s");
            LocalTime time = LocalTime.parse(date.split(" ")[1], timeFormatter);
            System.out.println("День: " + localDate.getDayOfMonth());
            System.out.println("День недели: " + localDate.getDayOfWeek().getValue());
            System.out.println("День месяца: " + localDate.getDayOfMonth());
            System.out.println("День года: " + localDate.getDayOfYear());
            System.out.println("Неделя месяца: " + localDate.get(WeekFields.of(Locale.getDefault()).weekOfMonth()));
            System.out.println("Неделя года: " + localDate.get(WeekFields.of(Locale.getDefault()).weekOfYear()));
            System.out.println("Месяц: " + localDate.getMonthValue());
            System.out.println("Год: " + localDate.getYear());
            System.out.println("AM или PM: " + (time.isAfter(LocalTime.NOON) ? "PM" : "AM"));
            System.out.println("Часы: " + (time.isAfter(LocalTime.NOON) ? time.getHour() - 12 : time.getHour()));
            System.out.println("Часы дня: " + time.getHour());
            System.out.println("Минуты: " + time.getMinute());
            System.out.println("Секунды: " + time.getSecond());

        }
        if (date.length() < 11 && date.contains(".")) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.y");
            LocalDate localDate = LocalDate.parse(date, formatter);
            System.out.println("День: " + localDate.getDayOfMonth());
            System.out.println("День недели: " + localDate.getDayOfWeek().getValue());
            System.out.println("День месяца: " + localDate.getDayOfMonth());
            System.out.println("День года: " + localDate.getDayOfYear());
            System.out.println("Неделя месяца: " + localDate.get(WeekFields.of(Locale.getDefault()).weekOfMonth()));
            System.out.println("Неделя года: " + localDate.get(WeekFields.of(Locale.getDefault()).weekOfYear()));
            System.out.println("Месяц: " + localDate.getMonthValue());
            System.out.println("Год: " + localDate.getYear());
        }
        if (date.length() < 11 && date.contains(":")) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:m:s");
            LocalTime time = LocalTime.parse(date, formatter);
            System.out.println("AM или PM: " + (time.isAfter(LocalTime.NOON) ? "PM" : "AM"));
            System.out.println("Часы: " + (time.isAfter(LocalTime.NOON) ? time.getHour() - 12 : time.getHour()));
            System.out.println("Часы дня: " + time.getHour());
            System.out.println("Минуты: " + time.getMinute());
            System.out.println("Секунды: " + time.getSecond());
        }
    }
}
