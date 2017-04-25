package com.javarush.task.task30.task3009;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

/* 
Палиндром?
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getRadix("112"));        //expected output: [3, 27, 13, 15]
        System.out.println(getRadix("123"));        //expected output: [6]
        System.out.println(getRadix("5321"));       //expected output: []
        System.out.println(getRadix("1A"));         //expected output: []
    }

    private static Set<Integer> getRadix(String number) {
        Set<Integer> result = new HashSet<>();
        String convertedNumber;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 2; i < 37; i++) {
            try {
                BigInteger bigInteger = new BigInteger(number);
                convertedNumber = bigInteger.toString(i);
            }
            catch (NumberFormatException e) {
                continue;
            }
            stringBuilder.append(convertedNumber);
            if (convertedNumber.equals(stringBuilder.reverse().toString()))
                result.add(i);
            stringBuilder.replace(0, stringBuilder.length(), "");
        }
        return result;
    }
}