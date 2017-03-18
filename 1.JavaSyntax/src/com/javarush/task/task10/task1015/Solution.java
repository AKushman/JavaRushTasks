package com.javarush.task.task10.task1015;

import java.util.ArrayList;

/* 
Массив списков строк
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String>[] arrayOfStringList = createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList() {
        //напишите тут ваш код
        ArrayList<String>[] list = new ArrayList[5];
        list[0] = new ArrayList<>();
        list[0].add("qwerty");
        list[0].add("asdfgh");
        list[1] = new ArrayList<>();
        list[1].add("qwerty");
        list[1].add("asdfgh");
        list[2] = new ArrayList<>();
        list[2].add("qwerty");
        list[2].add("asdfgh");
        list[3] = new ArrayList<>();
        list[3].add("qwerty");
        list[3].add("asdfgh");
        list[4] = new ArrayList<>();
        list[4].add("qwerty");
        list[4].add("asdfgh");
        return list;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList) {
        for (ArrayList<String> list : arrayOfStringList) {
            for (String s : list) {
                System.out.println(s);
            }
        }
    }
}