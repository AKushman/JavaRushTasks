package com.javarush.task.task32.task3210;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) {
        long number = Long.parseLong(args[1]);
        String text = args[2];
        try (RandomAccessFile file = new RandomAccessFile(args[0], "rw")) {
            file.seek(number);
            byte[] buffer = new byte[text.length()];
            file.read(buffer, 0, text.length());
            String textFromFile = convertByteToString(buffer);
            file.seek(file.length());
            if (text.equals(textFromFile))
                file.write("true".getBytes());
            else file.write("false".getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String convertByteToString(byte readBytes[]) {
        return new String(readBytes);
    }
}
