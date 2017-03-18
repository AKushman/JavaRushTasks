package com.javarush.task.task04.task0441;


/* 
Как-то средненько
*/
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());
        double sred = (double) (a + b + c) / 3;
        System.out.println(getMinRad(a, b, c, sred));

    }
    public static double abs(double sred, int x) {
        double radius = sred - x;
        if (radius > 0)
            return radius;
        else return -radius;
    }

    public static int getMinRad (int a, int b, int c, double sred) {
        int min = a;
        if (abs(sred, b) < abs(sred, min))
            min = b;
        if (abs(sred, c) < abs(sred, min))
            min = c;
        return min;
    }
}
