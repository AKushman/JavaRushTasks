package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        FileInputStream inputStream = new FileInputStream(file1);
        FileOutputStream outputStream = new FileOutputStream(file2);
        byte[] fromFile = new byte[inputStream.available()];
        if (inputStream.available() > 0) {
            int count = inputStream.read(fromFile);
            byte[] toFile = new byte[fromFile.length];
            int tfIndex = 0;
            for (int i = fromFile.length - 1; i > -1 ; i--) {
                toFile[tfIndex] = fromFile[i];
                tfIndex++;
            }
            outputStream.write(toFile, 0, count);
        }
        reader.close();
        inputStream.close();
        outputStream.close();
    }
}
