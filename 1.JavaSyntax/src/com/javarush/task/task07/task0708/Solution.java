package com.javarush.task.task07.task0708;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самая длинная строка
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            list.add(reader.readLine());
        }
        int maxLength = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() > maxLength)
                maxLength = list.get(i).length();
        }
        for (String s : list) {
            if (s.length() == maxLength)
                System.out.println(s);
        }
    }
}
