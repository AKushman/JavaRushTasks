package com.javarush.task.task32.task3202;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

/* 
Читаем из потока
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("C:\\temp\\test.txt"));
        System.out.println(writer.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is){
        StringWriter writer = new StringWriter();
        try {
            while (is.available() > 0) {
                writer.write(is.read());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            return writer;
        }
    }
}