package com.javarush.task.task34.task3403;

/* 
Разложение на множители с помощью рекурсии
*/
public class Solution {
    public void recursion(int n) {
        int divider = 2;
        while (n != 1) {
            if (n % divider == 0) {
                System.out.println(divider);
                recursion(n / divider);
                break;
            }
            else divider++;
        }
    }
}
