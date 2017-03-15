package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String resultFile = reader.readLine();
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        FileOutputStream outputStream = new FileOutputStream(resultFile);
        FileInputStream inputStream1 = new FileInputStream(file1);
        byte[] buffer = new byte[32000];
        while (inputStream1.available() > 0) {
            int count = inputStream1.read(buffer);
            outputStream.write(buffer, 0, count);
        }
        FileInputStream inputStream2 = new FileInputStream(file2);
        while (inputStream2.available() > 0) {
            int count = inputStream2.read(buffer);
            outputStream.write(buffer, 0, count);
        }
        reader.close();
        inputStream1.close();
        inputStream2.close();
        outputStream.close();
    }
}
