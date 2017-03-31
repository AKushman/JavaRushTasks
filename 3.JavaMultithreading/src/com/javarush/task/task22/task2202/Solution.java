package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) {
        String sb = "";
        try {
            String[] words = string.split(" ");
            sb = words[1] + " " + words[2] + " " + words[3] + " " + words[4];
        }
        catch (Exception e) {
            throw new TooShortStringException();
        }
        return sb;
    }

    public static class TooShortStringException extends RuntimeException {
    }
}
