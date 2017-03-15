package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileReader;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName = args[0];
        int spacesCounter = 0;
        int symbolsCounter = 0;
        FileReader fileReader = new FileReader(fileName);
        while (fileReader.ready()) {
            char c = (char) fileReader.read();
            symbolsCounter++;
            if (c == ' ')
                spacesCounter++;
        }
        fileReader.close();
        double d = (double) spacesCounter / symbolsCounter * 100;
        System.out.printf("%.2f", d);
    }
}
