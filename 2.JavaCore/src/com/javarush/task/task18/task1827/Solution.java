package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws Exception {
        String productName = "";
        String price = "";
        String quantity = "";
        for (int i = 1; i < args.length; i++) {
            if (i == args.length - 2)
                price = args[i];
            else if (i == args.length - 1)
                quantity = args[i];
            else productName += args[i] + " ";
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
//        List<Integer> idList = new ArrayList<>();
//        while (fileReader.ready()) {
//            String line = fileReader.readLine();
//            if (!line.isEmpty()) {
//                Integer id = Integer.parseInt(line.substring(0, 8).trim());
//                idList.add(id);
//            }
//        }
        List<String> items = new ArrayList<>();
        int maxID = 0;
        while (fileReader.ready()) {
            String line = fileReader.readLine();
            items.add(line);
            int ID = Integer.parseInt(line.substring(0, 8).trim());
            if (ID > maxID)
                maxID = ID;
        }
        fileReader.close();
        maxID++;
        String productInfo = String.format("%-8.8s%-30.30s%-8.8s%-4.4s", String.valueOf(maxID), productName, price, quantity);
        items.add(productInfo);
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName));
        for (int i = 0; i < items.size(); i++) {
            fileWriter.write(items.get(i));
            fileWriter.newLine();
        }
        fileWriter.close();
    }
}
