package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        int pass = 31071984;
        FileInputStream inputStream = new FileInputStream(args[1]);
        FileOutputStream outputStream = new FileOutputStream(args[2]);
        while (inputStream.available() > 0) {
            int in = inputStream.read();
            in = (byte) in ^ pass;
            outputStream.write(in);
        }
        inputStream.close();
        outputStream.close();
    }

}
