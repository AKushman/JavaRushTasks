package com.javarush.task.task05.task0529;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Консоль-копилка
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        while (true){
            String inputText = reader.readLine();
            if (inputText.equals("сумма"))
                break;
            else sum += Integer.parseInt(inputText);
        }
        System.out.println(sum);
    }
}
