package com.javarush.task.task30.task3010;

/* 
Минимальное допустимое основание системы счисления
*/

import java.math.BigInteger;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        int minRadix = 0;
        for (int i = 2; i < 37; i++) {
            try {
                BigInteger big = new BigInteger(args[0].toLowerCase(), i);
                minRadix = i;
                break;
            }
            catch (Exception e) {
                continue;
            }
        }
        if (minRadix != 0)
            System.out.println(minRadix);
        else System.out.println("incorrect");
    }
}