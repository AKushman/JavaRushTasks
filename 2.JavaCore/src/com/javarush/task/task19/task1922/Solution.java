package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        reader.close();
        BufferedReader fileReader = new BufferedReader(new FileReader(file));
        while (fileReader.ready()) {
            String line = fileReader.readLine();
            String[] wordsInLine = line.split(" ");
            int counter = 0;
            for (String s : wordsInLine) {
                if (words.contains(s))
                    counter++;
            }
            if (counter == 2)
                System.out.println(line);
        }
        fileReader.close();
    }
}
