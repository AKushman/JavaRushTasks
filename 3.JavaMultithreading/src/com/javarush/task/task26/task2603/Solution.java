package com.javarush.task.task26.task2603;


import java.util.Comparator;
import java.util.List;

/*
Убежденному убеждать других не трудно
*/
public class Solution {

    public static void main(String[] args) {

    }

    public static class CustomizedComparator<T> implements Comparator<T>{
        private Comparator<T>[] comparators;
        CustomizedComparator(Comparator<T>... vararg) {
            this.comparators = vararg;
        }

        public int compare(T o1, T o2) {
            int compareResult = 0;
            for (Comparator<T> comparator : comparators) {
                 compareResult = comparator.compare(o1, o2);
                if (compareResult != 0)
                    break;
            }
            return compareResult;
        }
    }
}
