package com.javarush.task.task04.task0425;

/* 
Цель установлена!
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int ox = Integer.parseInt(reader.readLine());
        int oy = Integer.parseInt(reader.readLine());
        if (ox > 0 && oy > 0)
            System.out.println(1);
        if (ox < 0 && oy > 0)
            System.out.println(2);
        if (ox < 0 && oy < 0)
            System.out.println(3);
        if (ox > 0 && oy < 0)
            System.out.println(4);
    }
}
