package com.javarush.task.task36.task3602;

import java.util.Collections;

/* 
Найти класс по описанию
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getExpectedClass());
    }

    public static Class getExpectedClass() {
        Class[] classes = Collections.class.getDeclaredClasses();

        try {
            return Class.forName("java.util.Collections$EmptyList");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;

    }
}
