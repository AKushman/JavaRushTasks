package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader firstFile = new BufferedReader(new FileReader(args[0]));
        FileWriter secondFile = new FileWriter(args[1]);
        while (firstFile.ready()) {
            String[] line = firstFile.readLine().split(" ");
            for (String s : line) {
                if (s.matches(".*[0-9].*"))
                    secondFile.write(s + " ");
            }
        }
        firstFile.close();
        secondFile.close();
    }
}
