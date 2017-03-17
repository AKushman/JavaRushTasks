package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileReader fileReader = new FileReader(fileName);
        String word = "";
        int worldCounter = 0;
        while (fileReader.ready()) {
            char symbol = (char) fileReader.read();
            if (Character.isLetter(symbol))
                word += symbol;
            else {
                    if ("world".equals(word))
                        worldCounter++;
                    word = "";
            }
        }
        System.out.println(worldCounter);
        reader.close();
        fileReader.close();
    }
}
