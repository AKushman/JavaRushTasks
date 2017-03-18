package com.javarush.task.task08.task0816;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static HashMap<String, Date> createMap() {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", new Date("JUNE 1 1980"));

        //напишите тут ваш код
        map.put("A", new Date("JULY 31 1984"));
        map.put("B", new Date("JANUARY 1 1981"));
        map.put("C", new Date("JANUARY 1 1981"));
        map.put("D", new Date("JANUARY 1 1981"));
        map.put("E", new Date("JANUARY 1 1981"));
        map.put("F", new Date("JANUARY 1 1981"));
        map.put("G", new Date("JANUARY 1 1981"));
        map.put("H", new Date("JANUARY 1 1981"));
        map.put("I", new Date("JANUARY 1 1981"));
        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map) {
        //напишите тут ваш код
        Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Date> pair = iterator.next();
            if (pair.getValue().getMonth() > 4 && pair.getValue().getMonth() < 8)
                iterator.remove();
        }
    }

    public static void main(String[] args) {

    }
}
