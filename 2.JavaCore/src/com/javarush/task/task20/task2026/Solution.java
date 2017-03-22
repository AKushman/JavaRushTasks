package com.javarush.task.task20.task2026;

/* 
Алгоритмы-прямоугольники
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        int count = getRectangleCount(a);
        System.out.println("count = " + count + ". Должно быть 2");
    }

    public static int getRectangleCount(byte[][] a) {
        int countRectangles = 0;
        byte[][] copy = a.clone();
        int leftUpX = 0;
        int leftUpY = 0;
        int downRightX = 0;
        int downRightY = 0;
        for (int i = 0; i < copy.length; i++) {
            for (int j = 0; j < copy[i].length; j++) {
                //left up angle coordinates
                if (copy[i][j] == 1) {
                    leftUpY = i;
                    leftUpX = j;
                    countRectangles++;
                }
                //right down angle coordinates
                for (int x2 = leftUpX; x2 < copy[i].length; x2++) {
                    if (copy[i][x2] == 0) {
                        downRightX = x2 - 1;
                        break;
                    }
                    if (x2 == copy[i].length - 1)
                        downRightX = x2;
                }
                for (int y2 = leftUpY; y2 < copy.length; y2++) {
                    if (copy[y2][j] == 0) {
                        downRightY = y2 - 1;
                        break;
                    }
                    if (y2 == copy.length - 1)
                        downRightY = y2;
                }
                //clean rectangle & count it
                for (int y = leftUpY; y <= downRightY; y++) {
                    for (int x = leftUpX; x <= downRightX; x++) {
                        copy[y][x] = 0;
                    }
                }
            }

        }
        return countRectangles;
    }
}
