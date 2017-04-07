package com.javarush.task.task26.task2601;

import java.util.Arrays;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {

    }

    public static Integer[] sort(Integer[] array) {
        //implement logic here
        Arrays.sort(array);
        int mid = array.length/2;
        double median = array[0];
        if (array.length % 2 != 0)
            median = array[mid];
        else median = (array[mid] + array[mid - 1]) / 2;
        final double finalMed = median;
        Arrays.sort(array, (o1, o2) -> (int) (Math.abs(o1 - finalMed) - Math.abs(o2 - finalMed)));

        return array;
    }
}
