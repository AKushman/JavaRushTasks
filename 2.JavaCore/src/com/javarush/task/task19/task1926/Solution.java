package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
        while (fileReader.ready()) {
            StringBuilder builder = new StringBuilder(fileReader.readLine());
            builder.reverse();
            System.out.println(builder.toString());
        }
        reader.close();
        fileReader.close();
    }
}
