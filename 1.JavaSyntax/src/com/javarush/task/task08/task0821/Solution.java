package com.javarush.task.task08.task0821;

import java.util.HashMap;
import java.util.Map;

/* 
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleList();
        printPeopleList(map);
    }

    public static Map<String, String> createPeopleList() {
        //напишите тут ваш код
        Map<String, String> map = new HashMap<>();
        map.put("Ivanov", "Ivan");
        map.put("Petrov", "Petr");
        map.put("Sidorov", "Semen");
        map.put("Pupkin", "Vasiliy");
        map.put("Sidorov", "Konst");
        map.put("Gates", "Bill");
        map.put("Jobes", "Steve");
        map.put("Maklai", "Mikluho");
        map.put("First", "Petr");
        map.put("Babkin", "Semen");
        return map;
    }

    public static void printPeopleList(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
