package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstFile = reader.readLine();
        String secondFile = reader.readLine();
        BufferedReader fileReader = new BufferedReader(new FileReader(firstFile));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(secondFile));
        String word = "";
        while (fileReader.ready()) {
            String[] words = fileReader.readLine().split(" ");
            for (int i = 0; i < words.length; i++) {
                try {
                    Integer.parseInt(words[i]);
                    word += words[i] + " ";
                }
                catch (NumberFormatException e) {

                }
            }
            fileWriter.write(word);
            word = "";
        }
        reader.close();
        fileReader.close();
        fileWriter.close();
    }
}
