package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstFile = reader.readLine();
        String secondFile = reader.readLine();
        reader.close();
        FileInputStream inputStream1 = new FileInputStream(firstFile);
        FileInputStream inputStream2 = new FileInputStream(secondFile);
        byte[] first = new byte[inputStream1.available()];
        byte[] second = new byte[inputStream2.available()];
        if (inputStream1.available() > 0)
            inputStream1.read(first);
        if (inputStream2.available() > 0)
            inputStream2.read(second);
        FileOutputStream outputStream = new FileOutputStream(firstFile);
        outputStream.write(second);
        outputStream.write(first);
        inputStream1.close();
        inputStream2.close();
        outputStream.close();
    }
}
