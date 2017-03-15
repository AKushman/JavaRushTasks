package com.javarush.task.task18.task1825;

/* 
Собираем файл
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        String resultFileName = fileName.substring(0, fileName.lastIndexOf(".part"));
        List<String> parts = new ArrayList<>();
        while (!"end".equals(fileName)) {
            parts.add(fileName);
            fileName = reader.readLine();
        }
        reader.close();
        Collections.sort(parts);
        FileOutputStream outputStream = new FileOutputStream(resultFileName);
        byte[] buffer = new byte[32000];
        for (String part : parts) {
            FileInputStream inputStream = new FileInputStream(part);
            while (inputStream.available() > 0) {
                int count = inputStream.read(buffer);
                outputStream.write(buffer, 0, count);
            }
            inputStream.close();
        }
        outputStream.close();
    }
}
