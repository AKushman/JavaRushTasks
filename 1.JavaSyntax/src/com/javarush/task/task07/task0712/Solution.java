package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            list.add(reader.readLine());
        }
        int maxLength = list.get(0).length();
        int minLength = list.get(0).length();
        for (String s : list) {
            if (s.length() > maxLength)
                maxLength = s.length();
            if (s.length() < minLength)
                minLength = s.length();
        }
        for (String s : list) {
            if (s.length() == maxLength || s.length() == minLength) {
                System.out.println(s);
                break;
            }
        }
    }
}
