package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
        FileWriter fileWriter = new FileWriter(args[1]);
        String newLine = "";
        while (fileReader.ready()) {
            String[] line = fileReader.readLine().split(" ");
            for (String s : line) {
                if (s.length() > 6)
                    newLine += s + ",";
            }
        }
        if (!newLine.isEmpty())
            fileWriter.write(newLine.substring(0, newLine.length() - 1));
        fileReader.close();
        fileWriter.close();
    }
}
