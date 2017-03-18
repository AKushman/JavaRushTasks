package com.javarush.task.task08.task0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Номер месяца
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String monthName = reader.readLine();
        List<String> months = Arrays.asList(
                "January",
                "February",
                "March",
                "April",
                "May",
                "June",
                "July",
                "August",
                "September",
                "October",
                "November",
                "December");
        for (int i = 0; i < months.size(); i++) {
            if (monthName.equalsIgnoreCase(months.get(i)))
                System.out.println(months.get(i) + " is " + (i + 1) + " month");
        }
    }
}
