package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
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
        double max = Collections.max(surnameValues.values());
        for (Map.Entry<String, Double> pair : surnameValues.entrySet()) {
            if (pair.getValue() == max)
                System.out.println(pair.getKey());
        }
    }
}
