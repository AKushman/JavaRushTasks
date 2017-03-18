package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        //напишите тут ваш код
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Ivanov", 100);
        map.put("Petrov", 700);
        map.put("Sidorov", 250);
        map.put("Pupkin", 470);
        map.put("Ernst", 1000);
        map.put("Gates", 800);
        map.put("Jobes", 1272);
        map.put("Maklai", 287);
        map.put("First", 490);
        map.put("Babkin", 2000);
        return map;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        //напишите тут ваш код
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> pair = iterator.next();
            if (pair.getValue() < 500)
                iterator.remove();
        }
    }

    public static void main(String[] args) {

    }
}