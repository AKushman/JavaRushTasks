package com.javarush.task.task34.task3413;

/* 
Кеш на основании SoftReference
*/

public class Solution {
    public static void main(String[] args) {
        SoftCache cache = new SoftCache();

        for (long i = 0; i < 25; i++) {
            cache.put(i, new AnyObject(i, null, null));
        }

        System.out.println(cache.get(14L));
        System.out.println(cache.put(15L, new AnyObject(15L, "replaced", null)));
        System.out.println(cache.remove(14L));
        System.out.println(cache.remove(15L));
    }
}