package com.javarush.task.task19.task1906;

/* 
Четные байты
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstFile = reader.readLine();
        String secondFile = reader.readLine();
        reader.close();
        FileReader fileReader = new FileReader(firstFile);
        FileWriter fileWriter = new FileWriter(secondFile);
        int byteCounter = 0;
        while (fileReader.ready()) {
            int c = fileReader.read();
            byteCounter++;
            if (byteCounter % 2 == 0)
                fileWriter.write(c);
        }
        fileReader.close();
        fileWriter.close();
    }
}
