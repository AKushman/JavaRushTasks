package com.javarush.task.task08.task0812;

import java.io.*;
import java.util.*;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(Integer.parseInt(reader.readLine()));
        }
        int counter = 1;
        int tmpCounter = 1;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) == list.get(i + 1))
                tmpCounter++;
            else {
                if (tmpCounter > counter)
                    counter = tmpCounter;
                tmpCounter = 1;
            }
        }
        if (counter > tmpCounter)
            System.out.println(counter);
        else System.out.println(tmpCounter);
    }
}