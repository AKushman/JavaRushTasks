package com.javarush.task.task04.task0434;


/* 
Таблица умножения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int col = 1;
        int row = 1;
        while (row <= 10) {
            while (col <= 10) {
                System.out.print(row * col + " ");
                col++;
            }
            col = 1;
            row++;
            System.out.println();
        }
    }
}
