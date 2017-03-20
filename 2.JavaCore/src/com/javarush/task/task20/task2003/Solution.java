package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws Exception {
        //implement this method - реализуйте этот метод
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileInputStream inputStream = new FileInputStream(fileName);
        reader.close();
        load(inputStream);
        inputStream.close();
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        PrintWriter fileWriter = new PrintWriter(outputStream);
        for (Map.Entry<String, String> params : properties.entrySet()) {
            String keyToWrite = params.getKey().replaceAll(" ", "\\\\ ");
            keyToWrite = keyToWrite.replaceAll("=", "\\\\=");
            keyToWrite = keyToWrite.replaceAll(":", "\\\\:");
            String valueToWrite = params.getValue().replaceAll(":", "\\\\:");
            fileWriter.println(keyToWrite + " = " + valueToWrite);
        }
        fileWriter.close();
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        BufferedReader fileReader = new BufferedReader(new InputStreamReader(inputStream));
        while (fileReader.ready()) {
            String line = fileReader.readLine();
            if (line.startsWith("#") || line.startsWith("!") || line.isEmpty())
                continue;
            while (line.endsWith("\\"))
                line = line.substring(0, line.length() - 1) +  fileReader.readLine();
            addToMap(line.trim());
        }

    }

    public void addToMap(String line) {
        String key = "";
        String value = "";
        char[] symbols =  line.toCharArray();
        for (int i = 0; i < symbols.length; i++) {
            char c = symbols[i];
            if ((c == ' ' || c == '=' || c ==':') && symbols[i - 1] != '\\') {
                key = line.substring(0, i).replaceAll("\\\\", "");
                value = line.substring(i).replaceAll("\\\\", "");
                break;
            }
        }
        value = value.trim();
        if (value.startsWith("=") || value.startsWith(":"))
            value = value.substring(1).trim();
        properties.put(key, value);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        try {
            solution.fillInPropertiesMap();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            OutputStream outputStream = new FileOutputStream("/home/user/GIT/second");
            solution.save(outputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
