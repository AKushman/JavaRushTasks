package com.javarush.task.task08.task0817;

import java.util.*;

/* 
Нам повторы не нужны
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

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map) {
        //напишите тут ваш код
        HashSet<String> names = new HashSet<>();
        HashSet<String> toDelete = new HashSet<>();
        for (Map.Entry<String, String> p :
                map.entrySet()) {
            if (names.contains(p.getValue()))
                toDelete.add(p.getValue());
            else names.add(p.getValue());
        }
        for (String s :
                toDelete) {
            removeItemFromMapByValue(map, s);
        }
    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value) {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args) {

    }
}
