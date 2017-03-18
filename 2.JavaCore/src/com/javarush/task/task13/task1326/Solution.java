package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        InputStream inputStream = new FileInputStream(fileName);
        Scanner scanner = new Scanner(inputStream);
        List<Integer> list = new ArrayList<>();
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            list.add(Integer.parseInt(line));
        }
        scanner.close();
        inputStream.close();
        reader.close();
        Collections.sort(list);
        for (Integer i : list) {
            if (i % 2 == 0)
                System.out.println(i);
        }
    }
}
