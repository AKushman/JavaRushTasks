package com.javarush.task.task05.task0532;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();
        int numbers = 0;
        while (numbers < 1) {
            numbers = Integer.parseInt(reader.readLine());
        }
        for (int i = 0; i < numbers; i++) {
            list.add(Integer.parseInt(reader.readLine()));
        }
        int maximum = Collections.max(list);

        //напишите тут ваш код

        System.out.println(maximum);
    }
}
