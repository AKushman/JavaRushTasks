package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int[] x = new int[15];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < x.length; i++) {
            x[i] = Integer.parseInt(reader.readLine());
        }
        int evenCounter = 0;
        int oddCounter = 0;
        for (int i = 0; i < x.length; i++) {
            if (i % 2 == 0)
                evenCounter += x[i];
            else oddCounter += x[i];
        }
        if (evenCounter > oddCounter)
            System.out.println("В домах с четными номерами проживает больше жителей.");
        else
            System.out.println("В домах с нечетными номерами проживает больше жителей.");
    }
}
