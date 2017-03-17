package com.javarush.task.task19.task1915;

/* 
Дублируем текст
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        reader.close();
        PrintStream consoleOut = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream myOut = new PrintStream(outputStream);
        System.setOut(myOut);
        testString.printSomething();
        String result = outputStream.toString();
        fileOutputStream.write(outputStream.toByteArray());
        System.setOut(consoleOut);
        System.out.println(result);
        fileOutputStream.close();
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

