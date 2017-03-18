package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Играем в Jолушку
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<Integer> mainList = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 20; i++) {
            mainList.add(Integer.parseInt(reader.readLine()));
        }
        for (int i = 0; i < mainList.size(); i++) {
            Integer x = mainList.get(i);
            if (x % 3 == 0)
                list3.add(x);
            if (x % 2 == 0)
                list2.add(x);
            if (x % 3 != 0 && x % 2 != 0)
                list.add(x);
        }
        printList(list3);
        printList(list2);
        printList(list);
    }

    public static void printList(List<Integer> list) {
        //напишите тут ваш код
        for (Integer i : list) {
            System.out.println(i);
        }
    }
}
