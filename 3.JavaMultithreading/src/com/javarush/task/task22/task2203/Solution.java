package com.javarush.task.task22.task2203;

/* 
Между табуляциями
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException{
        String result = "";
        try {
            String[] words = string.split("\t");
            if (words.length < 3)
                throw new TooShortStringException();
            result = words[1];
        }
        catch (Exception e) {
            throw new TooShortStringException();
        }
        return result;
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
    }
}
