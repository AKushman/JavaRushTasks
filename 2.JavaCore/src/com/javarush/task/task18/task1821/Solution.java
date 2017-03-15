package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream(args[0]);
        Map<Character, Integer> charFrequency = new TreeMap<>();
        while (inputStream.available() > 0) {
            char c = (char) inputStream.read();
            charFrequency.merge(c, 1, (i, i2) -> i + i2);
        }
        inputStream.close();
        for (Map.Entry<Character, Integer> pair : charFrequency.entrySet()) {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
    }
}
