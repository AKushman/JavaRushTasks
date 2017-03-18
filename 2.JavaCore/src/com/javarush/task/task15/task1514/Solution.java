package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики 1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();
    static {
        labels.put(3.5, "ThreePointFive");
        labels.put(2d, "Two");
        labels.put(36.6, "Temperature");
        labels.put(4.9, "Zhigulevskoe");
        labels.put(5.0, "Excellent");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
