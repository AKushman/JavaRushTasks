package com.javarush.task.task09.task0922;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* 
Какое сегодня число?
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Date date = new Date(reader.readLine());
        SimpleDateFormat simpleDate = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);
        System.out.println(simpleDate.format(date).toUpperCase());
    }
}
