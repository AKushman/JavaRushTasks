package com.javarush.task.task04.task0433;


/* 
Гадание на долларовый счет
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int row = 0;
        int col = 0;
        while (col < 10) {
            while (row < 10) {
                System.out.print("S");
                row++;
            }
            row = 0;
            col++;
            System.out.println();
        }
    }
}
