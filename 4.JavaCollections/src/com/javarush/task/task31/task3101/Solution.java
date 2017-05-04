package com.javarush.task.task31.task3101;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* 
Проход по дереву файлов
*/
public class Solution {
    public static void main(String[] args) {
        File path = new File(args[0]);
        File resultFileAbsolutePath = new File(args[1]);
        File destination = new File(resultFileAbsolutePath.getParent() + "/allFilesContent.txt");
        FileUtils.renameFile(resultFileAbsolutePath, destination);
        try (FileOutputStream writer = new FileOutputStream(destination)) {
            checkSize(path);
            Collections.sort(files, Comparator.comparing(File::getName));
            for (File file : files) {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                while (reader.ready()) {
                    writer.write(reader.readLine().getBytes());
                }
                writer.write('\n');
                reader.close();
            }
        }
        catch (IOException e) {

        }

    }
    
    private static List<File> files = new ArrayList<>();

    public static void checkSize(File file) {
        if (file.isDirectory()) {
            for (File f : file.listFiles()) {
                if (f.length() != 0)
                    checkSize(f);
                else FileUtils.deleteFile(f);
            }
        }
        else {
            if (file.length() > 50)
                FileUtils.deleteFile(file);
            else files.add(file);
        }
    }
    
    public static void deleteFile(File file) {
        if (!file.delete()) System.out.println("Can not delete file with name " + file.getName());
    }

}
