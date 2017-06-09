package com.javarush.task.task37.task3714;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Древний Рим
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input a roman number to be converted to decimal: ");
        String romanString = bufferedReader.readLine();
        System.out.println("Conversion result equals " + romanToInteger(romanString));
    }

    public static int romanToInteger(String s) {
        Map<Character, Integer> romanDecimal = new HashMap<>();
        romanDecimal.put('I', 1);
        romanDecimal.put('V', 5);
        romanDecimal.put('X', 10);
        romanDecimal.put('L', 50);
        romanDecimal.put('C', 100);
        romanDecimal.put('D', 500);
        romanDecimal.put('M', 1000);
        char[] number = s.toCharArray();
        int result = 0;
        for (int i = 0; i < number.length - 1; i++) {
            Character ch = Character.toUpperCase(number[i]);
            Character nextCh = Character.toUpperCase(number[i + 1]);
            if (romanDecimal.get(ch) < romanDecimal.get(nextCh)) {
                result -= romanDecimal.get(ch);
            }
            else result += romanDecimal.get(ch);
        }
        result += romanDecimal.get(Character.toUpperCase(number[number.length - 1]));
        return result;
    }
}
