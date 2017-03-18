package com.javarush.task.task07.task0715;

import java.util.ArrayList;

/* 
Продолжаем мыть раму
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> list = new ArrayList<>();
        list.add("мама");
        list.add("мыла");
        list.add("раму");
        String s = "именно";
        for (int i = 0; i < list.size(); i++) {
            i++;
            if (i != list.size())
                list.add(i, s);
            else {
                list.add(s);
            }
        }
        for (String st : list) {
            System.out.println(st);
        }
    }
}
