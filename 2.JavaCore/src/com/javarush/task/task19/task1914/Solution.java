package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleOut = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream myOut = new PrintStream(outputStream);
        System.setOut(myOut);
        testString.printSomething();
        String[] in = outputStream.toString().split(" ");
        int res = 0;
        if ("+".equals(in[1]))
            res = Integer.parseInt(in[0]) + Integer.parseInt(in[2]);
        else if ("-".equals(in[1]))
            res = Integer.parseInt(in[0]) - Integer.parseInt(in[2]);
        else res = Integer.parseInt(in[0]) * Integer.parseInt(in[2]);
        String result = outputStream.toString().replaceAll("\n", "") + res;
        System.setOut(consoleOut);
        System.out.println(result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}