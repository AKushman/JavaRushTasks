package com.javarush.task.task08.task0815;

import java.util.HashMap;
import java.util.HashSet;

/* 
Перепись населения
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        //напишите тут ваш код
        HashMap<String, String> map = new HashMap<>();
        map.put("Ivanov", "Ivan");
        map.put("Petrov", "Petr");
        map.put("Sidorov", "Semen");
        map.put("Pupkin", "Vasiliy");
        map.put("Ernst", "Konst");
        map.put("Gates", "Bill");
        map.put("Jobes", "Steve");
        map.put("Maklai", "Mikluho");
        map.put("First", "Petr");
        map.put("Babkin", "Semen");
        return map;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name) {
        //напишите тут ваш код
        int counter = 0;
        for (String s : map.values()) {
            if (name.equals(s))
                counter++;
        }
        return counter;

    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName) {
        //напишите тут ваш код
        int counter = 0;
        for (String s : map.keySet()) {
            if (lastName.equals(s))
                counter++;
        }
        return counter;
    }

    public static void main(String[] args) {

    }
}
