package com.javarush.task.task31.task3109;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

/* 
Читаем конфиги
*/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Properties properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/properties.xml");
        properties.list(System.out);

        properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/properties.txt");
        properties.list(System.out);

        properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/notExists");
        properties.list(System.out);
    }

    public Properties getProperties(String fileName) {
        Properties properties = new Properties();
        Path path = Paths.get(fileName);
        try {
            if (fileName.endsWith(".xml"))
                properties.loadFromXML(new FileInputStream(path.toAbsolutePath().toString()));
            else {
                properties.load(new FileInputStream(path.toAbsolutePath().toString()));
            }
            return properties;
        }
        catch (IOException e) {
            return properties;

        }
    }
}
