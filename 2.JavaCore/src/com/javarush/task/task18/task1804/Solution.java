package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());
        int[] bytes = new int[256];
        while (inputStream.available() > 0) {
            bytes[inputStream.read() - 1]++;
        }
        inputStream.close();
        int minValue = 255;
        for (int i = 0; i < bytes.length; i++) {
            if (bytes[i] != 0 && bytes[i] < minValue)
                minValue = bytes[i];
        }
        for (int i = 0; i < bytes.length; i++) {
            if (bytes[i] == minValue)
                System.out.print((i+1) + " ");
        }

    }
}
