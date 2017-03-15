package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        String file3 = reader.readLine();
        FileInputStream inputStream = new FileInputStream(file1);
        FileOutputStream outputStream2 = new FileOutputStream(file2);
        FileOutputStream outputStream3 = new FileOutputStream(file3);
        if (inputStream.available() % 2 == 0) {
            byte[] buffer = new byte[inputStream.available() / 2];
            while (inputStream.available() > 0) {
                int count = inputStream.read(buffer);
                outputStream2.write(buffer, 0, count);
                count = inputStream.read(buffer);
                outputStream3.write(buffer, 0, count);
            }
        }
        else {
            byte[] buffer = new byte[inputStream.available() / 2];
            while (inputStream.available() > 0) {
                int count = inputStream.read(buffer);
                outputStream2.write(buffer, 0, count);
                outputStream2.write(inputStream.read());
                count = inputStream.read(buffer);
                outputStream3.write(buffer, 0, count);
            }
        }
        reader.close();
        inputStream.close();
        outputStream2.close();
        outputStream3.close();
    }
}
