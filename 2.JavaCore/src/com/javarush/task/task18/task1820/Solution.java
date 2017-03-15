package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstFile = reader.readLine();
        String secondFile = reader.readLine();
        BufferedReader fileReader = new BufferedReader(new FileReader(firstFile));
        FileOutputStream outputStream = new FileOutputStream(secondFile);
        while (fileReader.ready()) {
            String[] doubles = fileReader.readLine().split(" ");
            String ints = "";
            for (int i = 0; i < doubles.length; i++) {
                ints += String.valueOf(Math.round(Double.parseDouble(doubles[i])));
                ints += " ";
            }
            outputStream.write(ints.getBytes());
        }
        reader.close();
        fileReader.close();
        outputStream.close();
    }
}
