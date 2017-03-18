package com.javarush.task.task09.task0927;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* 
Десять котов
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap() {
        //напишите тут ваш код
        HashMap<String, Cat> cats = new HashMap<>();
        cats.put("a", new Cat("a"));
        cats.put("b", new Cat("b"));
        cats.put("c", new Cat("c"));
        cats.put("d", new Cat("d"));
        cats.put("e", new Cat("e"));
        cats.put("f", new Cat("f"));
        cats.put("g", new Cat("g"));
        cats.put("h", new Cat("h"));
        cats.put("i", new Cat("i"));
        cats.put("j", new Cat("j"));
        return cats;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map) {
        //напишите тут ваш код
        Set<Cat> cats = new HashSet<>();
        for (Map.Entry<String, Cat> pair : map.entrySet()) {
            cats.add(pair.getValue());
        }
        return cats;
    }

    public static void printCatSet(Set<Cat> set) {
        for (Cat cat : set) {
            System.out.println(cat);
        }
    }

    public static class Cat {
        private String name;

        public Cat(String name) {
            this.name = name;
        }

        public String toString() {
            return "Cat " + this.name;
        }

    }


}
