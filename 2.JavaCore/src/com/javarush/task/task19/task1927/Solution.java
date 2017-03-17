package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleOut = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream myOut= new PrintStream(outputStream);
        System.setOut(myOut);
        testString.printSomething();
        String testString = "JavaRush - курсы Java онлайн";
        String[] test = outputStream.toString().split("\n");
        String result = "";
        for (int i = 0; i < test.length; i++) {
            if (i != 0 && i % 2 == 0)
                result += testString + "\n";
            result += test[i] + "\n";
        }
        System.setOut(consoleOut);
        System.out.println(result);

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
