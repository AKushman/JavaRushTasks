package com.javarush.task.task04.task0420;

/* 
Сортировка трех чисел
*/

import java.io.*;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = new int[3];
        for (int i = 0; i < 3; i++) {
            nums[i] = Integer.parseInt(reader.readLine());
        }
        Arrays.sort(nums);
        for (int i = 2; i > -1; i--) {
            System.out.print(nums[i] + " ");
        }
    }

}
