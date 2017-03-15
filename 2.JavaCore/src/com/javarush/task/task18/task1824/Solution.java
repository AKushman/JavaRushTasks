package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = "";
        FileInputStream inputStream = null;
        while (true) {
            try   {
                filename = reader.readLine();
            }
            catch (IOException ex) {}
            try {
                inputStream = new FileInputStream(filename);
                inputStream.close();
            }
            catch (FileNotFoundException ex) {
                System.out.println(filename);
                break;
            }
            catch (IOException e) {}
        }
        try {
            reader.close();
        }
        catch (Exception e) {}
    }
}
