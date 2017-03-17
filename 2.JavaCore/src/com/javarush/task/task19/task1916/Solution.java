package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();
        BufferedReader reader1 = new BufferedReader(new FileReader(file1));
        BufferedReader reader2 = new BufferedReader(new FileReader(file2));
        List<String> firstFile = new ArrayList<>();
        List<String> secondFile = new ArrayList<>();
        firstFile.addAll(reader1.lines().collect(Collectors.toList()));
        secondFile.addAll(reader2.lines().collect(Collectors.toList()));
        reader1.close();
        reader2.close();
        int secondFileIndex = 0;
        for (int i = 0; i < firstFile.size(); i++) {
            String s1 = firstFile.get(i);
            if (secondFileIndex < secondFile.size()) {
                if (s1.equals(secondFile.get(secondFileIndex))) {
                    lines.add(new LineItem(Type.SAME, s1));
                    secondFileIndex++;
                }
                else if (s1.equals(secondFile.get(secondFileIndex + 1))) {
                    lines.add(new LineItem(Type.ADDED, secondFile.get(secondFileIndex)));
                    secondFileIndex++;
                    i--;
                }
                else {
                    lines.add(new LineItem(Type.REMOVED, s1));
                }
            }
            else lines.add(new LineItem(Type.REMOVED, s1));
        }
        while (secondFileIndex < secondFile.size()) {
            lines.add(new LineItem(Type.ADDED, secondFile.get(secondFileIndex)));
            secondFileIndex++;
        }

    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
