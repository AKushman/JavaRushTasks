package com.javarush.task.task20.task2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
Алгоритмы-числа
*/
public class Solution {
    private static final List<Long> armstrongNumbers = Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 153L, 370L, 371L, 407L, 1634L, 8208L, 9474L, 54748L, 92727L, 93084L, 548834L, 1741725L, 4210818L, 9800817L, 9926315L, 24678050L, 24678051L, 88593477L, 146511208L, 472335975L, 534494836L, 912985153L, 4679307774L);
    private static final long[][] matrix = new long[9][19];
    static {
        for (int y = 0; y < matrix.length; y++) {
            int n = y + 1;
            matrix[y][0] = n;
            long res = n;
            for (int x = 1; x < matrix[y].length; x++) {
                res *= n;
                matrix[y][x] = res;
            }
        }
    }

    public static long[] getNumbers(long N) {
        long[] result = null;
        long maxArmstrong = Collections.max(armstrongNumbers);
        List<Long> myArmstrong = new ArrayList<>();
        if (N <= maxArmstrong) {
            for (Long l : armstrongNumbers) {
                if (l <= N)
                    myArmstrong.add(l);
            }
        }
        else {
            myArmstrong.addAll(armstrongNumbers);
            for (long i = maxArmstrong + 1; i < N; i++) {
                if (checkNum(i))
                    myArmstrong.add(i);
            }
        }
        result = new long[myArmstrong.size()];
        for (int i = 0; i < myArmstrong.size(); i++) {
            result[i] = myArmstrong.get(i).longValue();
        }
        return result;
    }

    public static boolean checkNum(long numberToCheck) {
        int stepen = 0;
        long copy = numberToCheck;
        long result = 0;
        while (copy > 0) {
            copy /= 10;
            stepen++;
        }
        copy = numberToCheck;
        while (copy > 0) {
            int n = (int) copy % 10;
            copy /= 10;
            if (n != 0)
                result += matrix[n - 1][stepen - 1];
        }
        return result == numberToCheck;
    }



    public static void main(String[] args) {

    }
}
