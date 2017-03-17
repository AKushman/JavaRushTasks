package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstFile = reader.readLine();
        String secondFile = reader.readLine();
        BufferedReader fileReader = new BufferedReader(new FileReader(firstFile));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(secondFile));
        while (fileReader.ready()) {
            String line = fileReader.readLine().replaceAll("\\.", "!");
            fileWriter.write(line);
            fileWriter.newLine();
        }
        reader.close();
        fileReader.close();
        fileWriter.close();
    }
}
