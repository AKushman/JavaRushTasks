package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        while (!"exit".equals(fileName)) {
            new ReadThread(fileName).start();
            fileName = reader.readLine();
        }
        reader.close();

    }

    public static class ReadThread extends Thread {
        private  String fileName;
        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут

        @Override
        public void run() {
            byte[] bytes = new byte[256];
            try (FileInputStream inputStream = new FileInputStream(fileName)) {
                while (inputStream.available() > 0) {
                    bytes[inputStream.read() - 1]++;
                }
            }
            catch (IOException ex) {}
            int maxByte = 0;
            int bytePos = 0;
            for (int i = 0; i < bytes.length; i++) {
                if (bytes[i] > maxByte) {
                    maxByte = bytes[i];
                    bytePos = i + 1;
                }
            }
            resultMap.put(fileName, bytePos);
        }
    }
}
