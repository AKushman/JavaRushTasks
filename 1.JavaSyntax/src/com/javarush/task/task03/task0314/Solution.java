package com.javarush.task.task03.task0314;

/* 
Таблица умножения
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                System.out.print(numbers[j] * numbers[i] + " ");
            }
            System.out.println();
        }
    }
}
