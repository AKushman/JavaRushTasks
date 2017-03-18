package com.javarush.task.task04.task0429;

/* 
Положительные и отрицательные числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int minus = 0;
        int plus = 0;
        for (int i = 0; i < 3; i++) {
            int a = Integer.parseInt(reader.readLine());
            if (a > 0)
                plus++;
            if (a < 0)
                minus++;
        }
        System.out.println("количество отрицательных чисел: " + minus);
        System.out.println("количество положительных чисел: " + plus);
    }
}
