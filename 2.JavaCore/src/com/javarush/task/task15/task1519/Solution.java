package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напиште тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String s = reader.readLine();
            if ("exit".equals(s))
                break;
            if (s.contains(".")) {
                try {
                    Double d = Double.parseDouble(s);
                    print(d);
                    continue;
                }
                catch (NumberFormatException e) {

                }
            }
            else try {
                short sh = Short.parseShort(s);
                if (sh > 0 && sh < 128) {
                    print(sh);
                    continue;
                    }
                }
                catch (NumberFormatException e) {

                }
            try {
                Integer i = Integer.parseInt(s);
                print(i);
            }
            catch (NumberFormatException e) {
                print(s);
            }
        }
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
