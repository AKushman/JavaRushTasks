package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        if ( a < 0 || b < 0)
            throw new Exception();
        System.out.println(nod(a, b));
    }
    public static int nod(int a, int b) {
        int maxNod = a < b ? a : b;
        for (int i = maxNod; i > -1 ; i--) {
            if (a % i == 0 && b % i == 0)
                return i;
        }
        return maxNod;
    }
}
