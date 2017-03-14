package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String firstFile = reader.readLine();
            String secondFile = reader.readLine();
            Scanner sc = new Scanner(new File(firstFile));
            while (sc.hasNext()) {
                allLines.add(sc.nextLine());
            }
            sc = new Scanner(new File(secondFile));
            while (sc.hasNext()) {
                forRemoveLines.add(sc.nextLine());
            }
            sc.close();
            reader.close();
        }
        catch (IOException ex) {}

        try {
            new Solution().joinData();
        }
        catch (CorruptedDataException e) {}


    }

    public void joinData () throws CorruptedDataException {
       if (allLines.containsAll(forRemoveLines)) {
           allLines.removeAll(forRemoveLines);
       }
       else {
           allLines.clear();
           throw new CorruptedDataException();
       }
    }
}
