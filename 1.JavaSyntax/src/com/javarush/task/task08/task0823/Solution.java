package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        String changedString = "";
        //напишите тут ваш код
        String[] words = s.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals("")) continue;
            String c = String.valueOf(words[i].charAt(0));
            String newWord = words[i].replaceFirst(c, c.toUpperCase());
            changedString += newWord + " ";
        }

        System.out.println(changedString.trim());
    }
}
