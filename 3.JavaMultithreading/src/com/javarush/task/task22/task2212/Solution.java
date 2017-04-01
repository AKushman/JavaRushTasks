package com.javarush.task.task22.task2212;

/* 
Проверка номера телефона
*/

public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        if (telNumber == null || telNumber.isEmpty()) return false;
        int length = telNumber.length();
        int countDigits = telNumber.replaceAll("\\D", "").length();
        int indOpen = telNumber.indexOf("(");
        int indClose = telNumber.indexOf(")");
        int indMinus = telNumber.indexOf("-");
        if ((telNumber.charAt(0) == '+') && countDigits != 12) return false;
        if (telNumber.matches("(^\\(|^\\d)\\S+") && countDigits != 10) return false;
        if ((length - telNumber.replaceAll("\\-", "").length()) > 2) return false;
        if ((length - telNumber.replaceAll("\\-{2}", "").length()) > 0) return false;
        if (indOpen != -1 && (length - telNumber.replaceAll("\\(", "").length()) != 1) return false;
        if (indClose != -1 && (length - telNumber.replaceAll("\\)", "").length()) != 1) return false;
        if (indOpen != -1 && indClose != -1 && indClose - indOpen != 4) return false;
        if (indClose != -1 && indMinus != -1 && indMinus < indClose) return false;
        if (!telNumber.matches("\\S+\\d$")) return false;
        try {
            Long.parseLong(telNumber.replaceAll("[\\(,\\),\\+\\-]", ""));
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
