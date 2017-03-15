package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String filename = args[0];
        FileReader fileReader = new FileReader(filename);
        int engCounter = 0;
        while (fileReader.ready()) {
            char c = (char) fileReader.read();
            if (String.valueOf(c).matches("[a-zA-Z]"))
                engCounter++;
        }
        System.out.println(engCounter);
        fileReader.close();
    }
}
