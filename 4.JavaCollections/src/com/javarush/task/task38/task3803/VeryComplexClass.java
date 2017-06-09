package com.javarush.task.task38.task3803;

/* 
Runtime исключения (unchecked exception)
*/

public class VeryComplexClass {
    public void methodThrowsClassCastException() {
        Object o = new Object();
        String s = (String) o;
    }

    public void methodThrowsNullPointerException() {
        int[] x = null;
        System.out.println(x[4]);
    }

    public static void main(String[] args) {
    }
}
