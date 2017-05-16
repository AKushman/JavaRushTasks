package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] allBytes = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPLKJHGFDSAZXCVBNM1234567890".getBytes();
        byte[] lower = "qwertyuiopasdfghjklzxcvbnm".getBytes();
        byte[] upper = "QWERTYUIOPLKJHGFDSAZXCVBNM".getBytes();
        byte[] digits = "1234567890".getBytes();
        List<Character> passSymbols = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            char symbol = (char) allBytes[(int)(Math.random() * allBytes.length)];
            passSymbols.add(symbol);
        }
        passSymbols.add((char) lower[(int)(Math.random() * lower.length)]);
        passSymbols.add((char) upper[(int)(Math.random() * upper.length)]);
        passSymbols.add((char) digits[(int)(Math.random() * digits.length)]);
        Collections.shuffle(passSymbols);
        for (Character c : passSymbols) {
            outputStream.write(c.charValue());
        }
        return outputStream;
    }
}