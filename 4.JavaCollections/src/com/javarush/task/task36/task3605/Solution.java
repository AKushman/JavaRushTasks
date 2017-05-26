package com.javarush.task.task36.task3605;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;

/* 
Использование TreeSet
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        TreeSet<Character> chars = new TreeSet<>();
        while (reader.ready()) {
            char[] line = reader.readLine().toCharArray();
            for (char c: line) {
                if ((c > 64 && c < 91) || (c > 96 && c < 123))
                    chars.add(Character.valueOf(c));
            }
        }
        int counter = 0;
        for (Character c : chars) {
            System.out.print(c);
            counter++;
            if (counter == 5)
                break;
        }
    }
}
