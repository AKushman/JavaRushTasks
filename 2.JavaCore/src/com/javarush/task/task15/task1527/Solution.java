package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        reader.close();
        String paramString = url.substring(url.indexOf("?") + 1);
        String[] params = paramString.split("&");
        String objValue = null;
        for (int i = 0; i < params.length; i++) {
            String paramName = params[i].split("=")[0];
            if ("obj".equals(paramName))
                objValue = params[i].split("=")[1];
            System.out.print(paramName + " ");
        }
        System.out.println();
        if (objValue != null) {
            try {
                alert(Double.parseDouble(objValue));
            } catch (NumberFormatException e) {
                alert(objValue);
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
