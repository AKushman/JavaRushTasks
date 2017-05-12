package com.javarush.task.task32.task3201;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/*
Запись в существующий файл
*/
public class Solution {
    public static void main(String... args) {
        try (RandomAccessFile ras = new RandomAccessFile(args[0], "rw")) {
            long position = Long.parseLong(args[1]);
            if (ras.length() > position) {
                ras.seek(position);
            }
            else ras.seek(ras.length());
            ras.write(args[2].getBytes());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
