package com.javarush.task.task07.task0704;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Переверни массив
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int x[] = new int[10];
        for (int i = 0; i < x.length; i++) {
            x[i] = Integer.parseInt(reader.readLine());
        }
        int newX[] = new int[10];
        int newIndex = 0;
        for (int i = x.length - 1; i > -1; i--) {
            newX[newIndex] = x[i];
            newIndex++;
        }
        for (int i = 0; i < newX.length; i++) {
            System.out.println(newX[i]);
        }
    }
}

