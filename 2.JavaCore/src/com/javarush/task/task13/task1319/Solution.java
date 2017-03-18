package com.javarush.task.task13.task1319;

import java.io.*;

/* 
Запись в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        OutputStream outputStream = new FileOutputStream(reader.readLine());
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
        while (true) {
            String s = reader.readLine();
            writer.write(s);
            writer.newLine();
            if (s.equals("exit"))
                break;
        }
        writer.close();
        outputStream.close();
        reader.close();
    }
}
