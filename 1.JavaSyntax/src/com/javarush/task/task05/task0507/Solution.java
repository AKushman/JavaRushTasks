package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        int counter = 0;
        int x = 0;
        while (x != -1) {
            x = Integer.parseInt(reader.readLine());
            if (x == -1 && counter !=0) {
                System.out.println((double) sum / counter);
            }
            else if (x == -1 && counter == 0)
                System.out.println(sum);
            sum += x;
            counter++;
        }
    }
}

