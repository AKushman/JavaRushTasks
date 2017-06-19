package com.javarush.task.task39.task3909;

/* 
Одно изменение
*/
public class Solution {
    public static void main(String[] args) {

    }

    public static boolean isOneEditAway(String first, String second) {
        int sizeDiff = Math.abs(first.length() - second.length());
        if (sizeDiff > 1)
            return false;
        if (first.equals("") && second.equals(""))
            return true;
        if(first.equals(second))
            return true;
        if (first.length() == second.length()) {
            for (int i = 0; i < first.length(); i++) {
                StringBuilder b1 = new StringBuilder(first);
                StringBuilder b2 = new StringBuilder(second);
                if (b1.deleteCharAt(i).toString().equals(b2.deleteCharAt(i).toString()))
                    return true;
            }
        }
        if (first.length() > second.length()) {
            for (int i = 0; i < first.length(); i++) {
                StringBuilder b1 = new StringBuilder(first);
                if (b1.deleteCharAt(i).toString().equals(second))
                    return true;
            }
        }
        if (first.length() < second.length()) {
            for (int i = 0; i < second.length(); i++) {
                StringBuilder b2 = new StringBuilder(second);
                if (b2.deleteCharAt(i).toString().equals(first))
                    return true;
            }
        }
        return false;
    }
}
