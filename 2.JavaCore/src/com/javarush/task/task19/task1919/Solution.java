package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
        Map<String, Double> surnameValues = new TreeMap<>();
        while (fileReader.ready()) {
            String[] line = fileReader.readLine().split(" ");
            double val = Double.parseDouble(line[1]);
            surnameValues.merge(line[0], val, (d1, d2) -> d1 + d2);
        }
        fileReader.close();
        for (Map.Entry<String, Double> pair : surnameValues.entrySet()) {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
    }
}
