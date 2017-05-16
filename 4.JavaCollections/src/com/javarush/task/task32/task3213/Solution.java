package com.javarush.task.task32.task3213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/* 
Шифр Цезаря
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringReader reader = new StringReader("Khoor Dpljr");
        System.out.println(decode(reader, -3));  //Hello Amigo

    }

    public static String decode(StringReader reader, int key) throws IOException {
        StringWriter writer = new StringWriter();
        try {
            BufferedReader br = new BufferedReader(reader);
            while (br.ready()) {
                byte[] tmp = br.readLine().getBytes();
                for (byte b : tmp) {
                    writer.write(b + key);
                }
            }
        }
        finally {
            return writer.toString();
        }

    }

}
