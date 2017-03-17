package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstFile = reader.readLine();
        String secondFile = reader.readLine();
        BufferedReader fileReader = new BufferedReader(new FileReader(firstFile));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(secondFile));
        String[] punktuation = {"\\.", ",", ";", ":", "!", "\\?", "-", "\\(", "\\)", "\\[", "\\]", "\\{", "\\}", "\"", "'", "<", ">"};
        while (fileReader.ready()) {
            String line = fileReader.readLine();
            for (int i = 0; i < punktuation.length; i++) {
                line = line.replaceAll(punktuation[i], "");
            }
            fileWriter.write(line);

        }
        reader.close();
        fileReader.close();
        fileWriter.close();
    }
}
