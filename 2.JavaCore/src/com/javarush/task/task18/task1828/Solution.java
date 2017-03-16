package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    private static final Map<Integer, String> priceList = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        while (fileReader.ready()) {
            String line = fileReader.readLine();
            int ID = Integer.parseInt(line.substring(0, 8).trim());
            priceList.put(ID, line);
        }
        reader.close();
        fileReader.close();
        int idToUpdateOrDelete = Integer.parseInt(args[1]);
        if (args.length != 0 && "-u".equals(args[0])) {
            String prodName = "";
            String price = args[args.length - 2];
            String quantity = args[args.length - 1];
            for (int i = 2; i < args.length - 2; i++) {
                prodName += args[i] + " ";
            }
            String item = String.format("%-8.8s%-30.30s%-8.8s%-4.4s", String.valueOf(idToUpdateOrDelete), prodName, price, quantity);
            updatePrice(idToUpdateOrDelete, item);
        }
        if (args.length != 0 && "-d".equals(args[0])) {
            deleteItem(idToUpdateOrDelete);
        }
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName));
        for (Map.Entry<Integer, String> pair : priceList.entrySet()) {
            fileWriter.write(pair.getValue());
            fileWriter.newLine();
        }
        fileWriter.close();
    }

    public static void updatePrice(int ID, String itemInfo) {
        priceList.put(ID, itemInfo);
    }

    public static void deleteItem(int ID) {
        priceList.remove(ID);
    }
}
